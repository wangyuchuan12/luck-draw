package com.wyc.common.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;



@Configuration
@ComponentScan(basePackages = "com.wyc", excludeFilters = {
        @Filter(type = FilterType.ASSIGNABLE_TYPE, value = WebConfig.class),
        @Filter(type = FilterType.ASSIGNABLE_TYPE, value = DatabaseConfig.class) })
public class AppConfig {
  public AppConfig() {
	System.out.println("被初始化");
  }
}
