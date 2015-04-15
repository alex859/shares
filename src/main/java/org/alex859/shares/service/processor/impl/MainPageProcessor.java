package org.alex859.shares.service.processor.impl;

import org.alex859.shares.model.ShareData;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@Service
@ConfigurationProperties(prefix = "hl.companyInformation")
public class MainPageProcessor extends AbstractHtmlProcessor
{
   private static final Logger LOGGER = LoggerFactory.getLogger(MainPageProcessor.class);

   private static final String PRICE_CSS = ".ask";
   private static final String ISIN_CSS = "#security-factsheet > div.float-right.box-1f2col > div:nth-child(1) > div > dl > dd:nth-child(4)";

   @Override
   protected void internalProcess(final Document doc, final ShareData shareData)
   {
      final String priceStr = doc.select(PRICE_CSS).text();
      final Double price = getPositiveValue(priceStr);
      LOGGER.debug("Setting price {}", price);
      shareData.setPrice(price);
   }
}
