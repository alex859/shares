package org.alex859.shares;

import org.alex859.shares.model.ShareData;
import org.apache.http.client.fluent.Request;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author alex859 (alessandro.ciccimarra@gmail.com).
 */
public class HargreavesLansdownScraper
{
    private static final String BASE_URL = "http://www.hl.co.uk/";
    private static final String URL = BASE_URL + "shares/stock-market-summary/ftse-all-share";
    private static final String BASE_DIR = "data/";
    private final Set<String> marketsToAnalyse;
    private final Set<String> interestingTabs;

    public HargreavesLansdownScraper()
    {
        marketsToAnalyse = new HashSet<>();
        marketsToAnalyse.add("FTSE All Share");
        marketsToAnalyse.add("FTSE AIM 100");

        interestingTabs = new HashSet<>();
        interestingTabs.add("broker-forecast");
        interestingTabs.add("director-deals");
        interestingTabs.add("financial-statements-and-reports");
        interestingTabs.add("dividends");
        interestingTabs.add("company-information");

    }

    /**
     *
     * @param shareDataLink Something like this {@code <a class="link-headline {Sedol:'B132NW2'} shareData" title="" href="/shares/shares-search-results/a/B132NW2">Ashmore Group plc</a>}
     * @return The basic extracted data
     */
    protected ShareData extractShareData(final Element shareDataLink)
    {
        final ShareData shareData = new ShareData();
        shareData.setName(shareDataLink.text());
        shareData.setUrl(BASE_URL + shareDataLink.attr("href"));
        if (shareData.getUrl() != null)
        {
            final String[] splitted = shareData.getUrl().split("/");
            shareData.setSedol(splitted[splitted.length-1]);
        }
        // System.out.println(shareData);
        return shareData;
    }

    /**
     * Explores the market page for the given URL to find shares. Explores next page if available (for paginated markets).
     *
     * @param marketUrl The market URL to explore
     * @return The set of {@link org.alex859.shares.model.ShareData} for the given market
     */
    protected Set<ShareData> processMarketPage(final String marketUrl)
    {
        final Set<ShareData> result = new HashSet<>();
        final Document document = readHtml(marketUrl);

        Element nextPageElement = document.select(".marketsChangeViewPage").first();
        if (nextPageElement != null)
        {
            nextPageElement = nextPageElement.select("table > tbody > tr > td.align-right > strong > a").first();
            if (nextPageElement != null)
            {
                result.addAll(processMarketPage(getBaseUrl(marketUrl) + nextPageElement.attr("href")));
            }
        }

        result.addAll(document.select(".shareData")
                .stream()
                .map(this::extractShareData)
                .collect(Collectors.toList()));

        return result;
    }

    /**
     * Looks for more information about the share.
     *
     * @param shareData The share to be populated
     */
    protected void downloadShareData(final ShareData shareData)
    {
        try
        {
            final Path filePath = Paths.get("data/" + shareData.getSedol() + "/main");
            Files.createDirectories(filePath.getParent());
            final Document document = readHtml(shareData.getUrl());
            if (document != null)
            {
                Files.write(filePath, document.html().getBytes());

                // get extra data
                document.select("#nav-container > ul > li > a")
                        .stream()
                        .parallel()
                        .map(a -> a.attr("href"))
                        .filter(url -> interestingTabs.contains(getLastUrlPart(url)))
                        .forEach(url -> getHtmlAndSave(url, filePath));
            }
            else
            {
                System.out.println("Unable to save: " + shareData.getSedol());
            }
        }
        catch (final IOException e)
        {
            System.out.println("Error creating file");
            e.printStackTrace();
        }
    }

    private void getHtmlAndSave(final String url, final Path path)
    {
        final String html = getHtml(url);
        try
        {
            Files.write(Paths.get(path.toString() + "_" + getLastUrlPart(url)), html.getBytes());
        }
        catch (IOException e)
        {
            System.out.println("Error writing file");
            e.printStackTrace();
        }
    }

    public void exec()
    {
        final Document mainPage = readHtml(URL);
        final Set<ShareData> shareData = new HashSet<>();
        mainPage.select("#section-navigation > ul > li:nth-child(3) > ul > li > a")
                .stream()
                .filter(liTag -> marketsToAnalyse.contains(liTag.text()))
                .map(aTag -> processMarketPage(aTag.attr("href")))
                .forEach(shareData::addAll);

        shareData
                .stream()
                .parallel()
                .forEach(this::downloadShareData);

        System.out.println(shareData.size());
    }

    private String getBaseUrl(final String url)
    {
        return url.split("\\?")[0];
    }

    private String getLastUrlPart(final String url)
    {
        final String[] splitted =url.split("/");
        return splitted[splitted.length -1];
    }

    protected Document readHtml(final String url)
    {
        final String fileStr = getHtml(url);
        if (fileStr != null)
        {
            return Jsoup.parse(fileStr);
        }

        return null;
    }

    protected String getHtml(final String url)
    {
        try
        {
            // System.out.println("*** Reading URL: " + url);
            return Request.Get(url).execute().returnContent().asString();
            // System.out.println("*** Done URL: " + url);
        }
        catch (final IOException e)
        {
            System.out.println("Error reading url: " + url);
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) throws IOException
    {
        new HargreavesLansdownScraper().exec();

    }
}
