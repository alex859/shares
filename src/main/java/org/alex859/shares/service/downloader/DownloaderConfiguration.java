package org.alex859.shares.service.downloader;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@ConfigurationProperties(prefix = "hl")
@Component
public class DownloaderConfiguration
{
    private String baseUrl;
    private String marketUrl;
    private String destinationFolder;
    private List<String> marketsToAnalyse;
    private List<String> interestingTabs;

    public String getBaseUrl()
    {
        return baseUrl;
    }

    public void setBaseUrl(final String baseUrl)
    {
        this.baseUrl = baseUrl;
    }

    public String getDestinationFolder()
    {
        return destinationFolder;
    }

    public void setDestinationFolder(final String destinationFolder)
    {
        this.destinationFolder = destinationFolder;
    }

    public List<String> getInterestingTabs()
    {
        return interestingTabs;
    }

    public void setInterestingTabs(final List<String> interestingTabs)
    {
        this.interestingTabs = interestingTabs;
    }

    public List<String> getMarketsToAnalyse()
    {
        return marketsToAnalyse;
    }

    public void setMarketsToAnalyse(final List<String> marketsToAnalyse)
    {
        this.marketsToAnalyse = marketsToAnalyse;
    }

    public String getMarketUrl()
    {
        return marketUrl;
    }

    public void setMarketUrl(final String marketUrl)
    {
        this.marketUrl = marketUrl;
    }
}
