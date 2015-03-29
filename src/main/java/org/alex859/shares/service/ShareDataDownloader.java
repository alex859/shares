package org.alex859.shares.service;

import org.alex859.shares.model.ShareData;

/**
 * @author alex859 (alessandro.ciccimarra@gmail.com).
 */
public interface ShareDataDownloader
{
    void downloadAll();
    ShareData get(String isin);
}
