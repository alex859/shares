package org.alex859.shares.controller;

import org.alex859.shares.model.ShareData;
import org.alex859.shares.service.downloader.impl.LondonStockExchangeCategoryDownloader;
import org.alex859.shares.service.processor.ShareDataProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@Controller
@ConfigurationProperties(prefix = "hl")
public class CommandLineController implements CommandLineRunner
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineController.class);
    private String destinationFolder;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private List<ShareDataProcessor> processors;

    @Autowired
    private LondonStockExchangeCategoryDownloader lseCategoryDownloader;

    @Override
    public void run(final String... args) throws Exception
    {
        try
        {
            final Path filePath = Paths.get(getDestinationFolder());
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
            final ShareData shareData = new ShareData();
            Files.list(folder)
//                 .parallel()
                    .map(Path::toFile)
                    .forEach(file ->
                                    processors
                                            .stream()
                                            .filter(processor -> processor.canProcess(file))
                                            .forEach(processor -> processor.process(file, shareData))
                    );

            final ShareData lseShareData = lseCategoryDownloader.get(shareData.getIsin());
            if (lseShareData != null)
            {
                shareData.setCategory(lseShareData.getCategory());
                shareData.setSubCategory(lseShareData.getSubCategory());
            }

            mongoTemplate.save(shareData);

        } catch (final IOException e)
        {
            LOGGER.error("Error processing share data folder {}", folder, e);
        }
    }

    public String getDestinationFolder()
    {
        return destinationFolder;
    }

    public void setDestinationFolder(final String destinationFolder)
    {
        this.destinationFolder = destinationFolder;
    }
}
