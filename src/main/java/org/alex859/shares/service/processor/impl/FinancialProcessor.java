package org.alex859.shares.service.processor.impl;

import org.alex859.shares.model.FinancialData;
import org.alex859.shares.model.ShareData;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 *         <p>
 *         Expected financials order:
 *         Revenue:
 *         Operating Profit / (Loss):
 *         Net Interest:
 *         Profit Before Tax:
 *         Profit after tax from continuing operations:
 *         Profit after tax from discontinuing operations:
 *         Profit for the period:
 *         Equity holders of parent company:
 *         Minority Interests / Other Equity:
 *         Total Dividend Paid:
 *         Retained Profit / (Loss) for the Financial Year:
 *         Basic:
 *         Diluted:
 *         Adjusted:
 *         Dividend per Share:
 *         Property, Plant & Equipment:
 *         Intangible Assets:
 *         Investment Properties:
 *         Investments:
 *         Other Financial Assets:
 *         Other Non-Current Assets:
 *         Inventories:
 *         Trade and Other Receivables:
 *         Cash at Bank & In Hand:
 *         Current Asset Investments:
 *         Other Current Assets:
 *         Other Assets:
 *         Total Assets:
 *         Borrowings:
 *         Other Current Liabilities:
 *         Net Current Assets:
 *         Borrowings:
 *         Provisions:
 *         Other Non-Current Liabilities:
 *         Other Liabilities:
 *         Total Liabilities:
 *         Net Assets:
 *         Share Capital:
 *         Share Premium Account:
 *         Other Reserves:
 *         Retained Earnings:
 *         Shareholders Funds:
 *         Minority Interests / Other Equity:
 *         Total Equity:
 */
@Service
@ConfigurationProperties(prefix = "hl.financial")
public class FinancialProcessor extends AbstractHtmlProcessor
{
   private static final Logger LOGGER = LoggerFactory.getLogger(FinancialProcessor.class);

   private static final String FACT_SHEET_HEAD_CSS = "#security-factsheet > div.tab-content.margin-top.float-left > div > table > tbody > .factsheet-head";
   private static final String DATE_ELEMENTS_CSS = "#security-factsheet > div.tab-content.margin-top.float-left > div > table > tbody > tr:nth-child(1) > th";
   private static final DateFormatter DATE_FORMATTER = new DateFormatter("dd/MM/yyyy");
   private static final Pattern NEGATIVE_VALUE_PATTERN = Pattern.compile("\\((.*?)\\)");

   @Override
   protected void internalProcess(final Document doc, final ShareData shareData)
   {

      ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
      final Elements heads = doc.select(FACT_SHEET_HEAD_CSS);

      // we want both income statement and balance sheet
      if (heads.size() == 2)
      {
         final List<FinancialData> financialData = getFinancialDataMap(doc);

         final Field[] fields = FinancialData.class.getDeclaredFields();

         final String rows = "#security-factsheet > div.tab-content.margin-top.float-left > div > table > tbody > tr > .align-left";
         int[] fieldIndex = new int[1];
         fieldIndex[0] = 0;

         doc.select(rows)
                 .stream()
                 .filter(element -> !element.text().contains("nbsp;") && element.text().contains(":"))
                 .map(Element::parent)
                 .forEach(row ->
                 {
                    final Field fieldToUpdate = fields[fieldIndex[0]];
                    fieldIndex[0]++;
                    int[] dateIndex = new int[1];
                    dateIndex[0] = 0;
                    row.children()
                            .stream()
                            .skip(1)
                            .forEach(td ->
                            {

                               final Double value = getValue(td.text());
                               try
                               {
                                  BeanUtils.setProperty(financialData.get(dateIndex[0]), fieldToUpdate.getName(), value);
                                  LOGGER.info("Setting {}: {}", fieldToUpdate.getName(), value);
                               }
                               catch (final Exception e)
                               {
                                  LOGGER.error("Error setting value", e);
                               }

                               dateIndex[0]++;
                            });
                 });

         shareData.setFinancialData(financialData);
         if (!CollectionUtils.isEmpty(financialData))
         {
            shareData.setLastFinancialData(financialData.get(0));
         }
      }
   }

   protected List<FinancialData> getFinancialDataMap(final Document doc)
   {
      final List<FinancialData> result = new ArrayList<>();
      // the first one is the first coloumn header and it is not a date

      doc.select(DATE_ELEMENTS_CSS)
              .stream()
              .skip(1)
              .map(dateStr ->
              {
                 try
                 {
                    return DATE_FORMATTER.parse(dateStr.text(), Locale.ENGLISH);
                 }
                 catch (final ParseException e)
                 {
                    LOGGER.error("Error parsing date", e);
                 }

                 return null;
              })
              .forEach(date -> result.add(new FinancialData(date)));

      return result;
   }

   protected Double getValue(final String str)
   {
      final Matcher matcher = NEGATIVE_VALUE_PATTERN.matcher(str);
      if (matcher.find())
      {
         final Double result = getPositiveValue(matcher.group(1));
         return result != null ? -1 * result : null;
      }
      else
      {
         return getPositiveValue(str);
      }
   }

}
