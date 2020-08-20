package com.retail.loyalty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringBootMainApplication{
    public static void main(String[] args){

        SpringApplication.run(SpringBootMainApplication.class,args);

    }
}

