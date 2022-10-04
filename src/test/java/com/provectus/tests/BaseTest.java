package com.provectus.tests;

import com.provectus.driver.WebdriverFactory;
import com.provectus.driver.WebdriverType;
import com.provectus.tests.listeners.CustomExtentPageListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.IOException;

@Listeners(CustomExtentPageListener.class)
public class BaseTest {

    @BeforeMethod
    public void setUp() throws IOException {
        WebdriverFactory.initDriver(WebdriverType.CHROME);
    }

    static{
        System.setProperty("extent.reporter.html.start", "true");
        System.setProperty("extent.reporter.html.out", "target/extentReport/ExtentHtml.html");
    }

}
