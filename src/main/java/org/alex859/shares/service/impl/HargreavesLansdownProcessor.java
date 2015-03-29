package org.alex859.shares.service.impl;

import org.alex859.shares.service.ShareDataProcessor;
import org.alex859.shares.service.impl.util.DownloaderConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@Service
public class HargreavesLansdownProcessor implements ShareDataProcessor
{
    private static final Logger LOGGER = LoggerFactory.getLogger(HargreavesLansdownProcessor.class);

    private DownloaderConfiguration downloaderConfiguration;

    @Autowired
    public HargreavesLansdownProcessor(final DownloaderConfiguration downloaderConfiguration)
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
                    .forEach(System.out::println);
        } catch (final IOException e)
        {
            LOGGER.error("Error processing share data folder {}", folder, e);
        }
    }
}
