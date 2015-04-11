package org.alex859.shares.service.processor;

import java.io.File;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
public interface ShareDataProcessor
{
    void processAll();
    void process(File file);
    void process(String html);
}
