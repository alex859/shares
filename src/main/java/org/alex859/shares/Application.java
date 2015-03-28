package org.alex859.shares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author alex859 (alessandro.ciccimarra@gmail.com).
 */
@EnableAutoConfiguration
@ComponentScan
public class Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
