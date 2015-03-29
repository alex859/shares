package org.alex859.shares.controller;

import org.alex859.shares.service.ShareDataDownloader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

/**
 * @author alex859 (alessandro.ciccimarra@gmail.com).
 */
@Controller
public class CommandLineController implements CommandLineRunner
{
    @Autowired
    private ShareDataDownloader provider;

    @Override
    public void run(final String... args) throws Exception
    {
        provider.get("");
    }
}
