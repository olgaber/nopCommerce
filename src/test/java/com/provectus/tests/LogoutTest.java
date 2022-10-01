package com.provectus.tests;

import com.provectus.components.Header;
import com.provectus.tests.helpers.HelperMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() throws InterruptedException {

        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signInUser();

        Header header = new Header();
        header.logOut();

        TimeUnit.SECONDS.sleep(4);

        Assert.assertTrue(header.getRegisterLink().isDisplayed());
        Assert.assertTrue(header.getLogInLink().isDisplayed());
        Assert.assertTrue(!header.getLogoutLink().isDisplayed());
        Assert.assertTrue(!header.getMyAccountLink().isDisplayed(),
                "'My account' link shouldn't be displayed");

    }

}
