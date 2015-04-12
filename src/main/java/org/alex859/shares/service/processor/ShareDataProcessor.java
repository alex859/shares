package org.alex859.shares.service.processor;

import org.alex859.shares.model.ShareData;

import java.io.File;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
public interface ShareDataProcessor
{
    void process(File file, ShareData shareData);
    void process(String html, ShareData shareData);
    boolean canProcess(File file);
}
