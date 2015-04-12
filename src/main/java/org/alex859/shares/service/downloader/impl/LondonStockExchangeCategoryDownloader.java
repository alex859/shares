package org.alex859.shares.service.downloader.impl;

import org.alex859.shares.model.ShareData;
import org.alex859.shares.service.downloader.ShareDataDownloader;
import org.apache.http.client.fluent.Request;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@Service
public class LondonStockExchangeCategoryDownloader implements ShareDataDownloader
{
   private static final Logger LOGGER = LoggerFactory.getLogger(LondonStockExchangeCategoryDownloader.class);

   private static final String LONDON_STOCK_EXCHANGE_URL = "http://www.londonstockexchange.com/exchange/searchengine/search.html?lang=en&x=0&y=0&q=";
   private static final String FIRST_SEARCH_RESULT_CSS = "#contentIndex > div.search_results_list > table > tbody > tr > td:nth-child(2) > a";
   private static final String CATEGORY_CSS = "#pi-colonna1-display > table:nth-child(14) > tbody > tr:nth-child(2) > td:nth-child(2)";
   private static final String SUB_CATEGORY_CSS = "#pi-colonna1-display > table:nth-child(14) > tbody > tr:nth-child(3) > td:nth-child(2)";

   @Override
   public void downloadAll()
   {

   }

   @Override
   public ShareData get(final String isin)
   {
      try
      {
         final String searchResponse = Request.Get(LONDON_STOCK_EXCHANGE_URL + isin).execute().returnContent().asString();
         final Document searchResponseDoc = Jsoup.parse(searchResponse);

         final Elements elements = searchResponseDoc.select(FIRST_SEARCH_RESULT_CSS);
         if (!CollectionUtils.isEmpty(elements))
         {
            final String url = elements.get(0).attr("href");
            final String detailPageStr = Request.Get(url).execute().returnContent().asString();
            final Document detailsPageDoc = Jsoup.parse(detailPageStr);
            final String category = detailsPageDoc.select(CATEGORY_CSS).text();
            final String subCategory = detailsPageDoc.select(SUB_CATEGORY_CSS).text();

            final ShareData shareData = new ShareData();
            shareData.setCategory(category);
            shareData.setSubCategory(subCategory);

            return shareData;
         }
      }
      catch (final IOException e)
      {
         LOGGER.error("Error downloading from LSE", e);
      }
      return null;
   }
}
