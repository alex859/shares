package org.alex859.shares.service.processor.impl;

import org.alex859.shares.service.processor.ShareDataProcessor;
import org.alex859.shares.service.downloader.DownloaderConfiguration;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@Service
public abstract class AbstractHtmlProcessor implements ShareDataProcessor
{
   private static final Logger LOGGER = LoggerFactory.getLogger(AbstractHtmlProcessor.class);

   private DownloaderConfiguration downloaderConfiguration;

   @Autowired
   public AbstractHtmlProcessor(final DownloaderConfiguration downloaderConfiguration)
   {
      this.downloaderConfiguration = downloaderConfiguration;
   }

   @Override
   public void processAll()
   {
      try
      {
         final Path filePath = Paths.get(downloaderConfiguration.getDestinationFolder());
         Files.list(filePath)
//                    .parallel()
                 .forEach(this::processFolder);
      } catch (final IOException e)
      {
         LOGGER.error("Error processing share data", e);
      }
   }

   protected void processFolder(final Path folder)
   {
      try
      {
         Files.list(folder)
//                 .parallel()
                 .forEach(path -> process(path.toFile()));
      } catch (final IOException e)
      {
         LOGGER.error("Error processing share data folder {}", folder, e);
      }
   }

   @Override
   public void process(final File file)
   {
      try
      {
         final Document doc = Jsoup.parse(file, "UTF-8");
         internalProcess(doc);
      } catch (IOException e)
      {
         LOGGER.error("Error reading file {}", file.getName(),  e);
      }
   }

   @Override
   public void process(final String html)
   {
      final Document doc = Jsoup.parse(html);
      internalProcess(doc);
   }

   protected abstract void internalProcess(final Document doc);
}
