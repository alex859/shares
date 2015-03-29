package org.alex859.shares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan(basePackages = "org.alex859")
@Configuration
public class Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
