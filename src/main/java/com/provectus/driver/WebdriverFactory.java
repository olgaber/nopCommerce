package com.provectus.driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class WebdriverFactory {

    public static void initDriver(WebdriverType webdriverType) throws IOException {
//        Configuration.browserSize = "1800x1050";
        File file = new File("src/main/resources/test.properties");

        Properties properties = new Properties();
        properties.load(new FileReader(file));

        //Configuration.baseUrl = "http://82.196.8.130";
        Configuration.baseUrl = properties.getProperty("url");
        Configuration.downloadsFolder = "downloads";
        Configuration.fileDownload = FileDownloadMode.FOLDER;
        Configuration.timeout = Long.parseLong(properties.getProperty("timeout"));
        Configuration.browser = webdriverType.name().toLowerCase();
    }

    public static void initDriver(){
        String webdriverType = System.getProperty("webdriverType", "chrome");
        try{
            WebdriverType webdriverTypeEnum = WebdriverType.valueOf(webdriverType.toUpperCase());
        } catch(Exception e){
            System.out.println("Webdriver type is not supported");
        }
    }
}
