package org.alex859.shares.service.processor.impl;

import org.alex859.shares.model.ShareData;
import org.alex859.shares.service.processor.ShareDataProcessor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
public abstract class AbstractHtmlProcessor implements ShareDataProcessor
{
   private static final Logger LOGGER = LoggerFactory.getLogger(AbstractHtmlProcessor.class);

   protected static final BigDecimal ONE_MILLION = new BigDecimal("1000000");
   private static final BigDecimal ONE_PENCE = new BigDecimal("0.01");

   protected String suffix;

   @Override
   public void process(final File file, final ShareData shareData)
   {
      Assert.notNull(shareData, "ShareData cannot be null");
      try
      {
         final Document doc = Jsoup.parse(file, "UTF-8");
         internalProcess(doc, shareData);
      } catch (IOException e)
      {
         LOGGER.error("Error reading file {}", file.getName(),  e);
      }
   }

   @Override
   public void process(final String html, final ShareData shareData)
   {
      Assert.notNull(shareData, "ShareData cannot be null");
      final Document doc = Jsoup.parse(html);
      internalProcess(doc, shareData);
   }

   public boolean canProcess(final File file)
   {
      return file.getName().contains(getSuffix());
   }

   protected abstract void internalProcess(final Document doc, final ShareData shareData);

   public String getSuffix()
   {
      return suffix;
   }

   public void setSuffix(final String suffix)
   {
      this.suffix = suffix;
   }

   protected BigDecimal getPositiveValue(String str)
   {
      BigDecimal multiplier = ONE_MILLION;
      if (str == null || str.isEmpty() || str.contains("n/a"))
      {
         return null;
      }

      if (str.startsWith("c"))
      {
         str = str.replace("c", "").trim();
      }

      if (str.endsWith("p"))
      {
         str = str.replace("p", "").trim();
         multiplier = ONE_PENCE;
      }
      try
      {
         return new BigDecimal(NumberFormat.getInstance().parse(str).toString()).multiply(multiplier);
      }
      catch (final Exception e)
      {
         LOGGER.warn("Error parsing value {}, setting null", str);
      }

      return null;
   }
}
