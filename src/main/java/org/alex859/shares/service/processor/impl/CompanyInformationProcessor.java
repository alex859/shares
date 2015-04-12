package org.alex859.shares.service.processor.impl;

import org.alex859.shares.model.ShareData;
import org.alex859.shares.service.downloader.DownloaderConfiguration;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@Service
@ConfigurationProperties(prefix = "hl.companyInformation")
public class CompanyInformationProcessor extends AbstractHtmlProcessor
{
   private static final Logger LOGGER = LoggerFactory.getLogger(CompanyInformationProcessor.class);

   private static final String EPIC_CSS = "#security-factsheet > div.float-right.box-1f2col > div:nth-child(1) > div > dl > dd:nth-child(2)";
   private static final String ISIN_CSS = "#security-factsheet > div.float-right.box-1f2col > div:nth-child(1) > div > dl > dd:nth-child(4)";

   @Override
   protected void internalProcess(final Document doc, final ShareData shareData)
   {
      final String epic = doc.select(EPIC_CSS).text();
      LOGGER.debug("Setting epic {}", epic);
      final String isin = doc.select(EPIC_CSS).text();
      LOGGER.debug("Setting isin {}", isin);
      shareData.setIsin(isin);
   }
}
