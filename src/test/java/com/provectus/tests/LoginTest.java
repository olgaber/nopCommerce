package com.provectus.tests;

import com.provectus.DataSource;
import com.provectus.components.Header;
import com.provectus.pages.MainPage;
import com.provectus.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest{

    @Test
    public void successfulLoginTest() {

        open("");
        MainPage mainPage = new MainPage();
        Assert.assertEquals(mainPage.getWelcomeMessageText(), DataSource.welcomeMessageHome, "The welcome messages text should be the same");

        Header header = new Header();
        SignInPage signInPage = header.goToSignInPage();
        Assert.assertEquals(signInPage.getWelcomeMessage(), DataSource.welcomeMessageSignIn, "The welcome messages text should be the same");

        signInPage.signIn(DataSource.email, DataSource.password);

        Assert.assertTrue(!header.getRegisterLink().isDisplayed());
        Assert.assertTrue(!header.getLogInLink().isDisplayed());
        Assert.assertTrue(header.getLogoutLink().isDisplayed());
        Assert.assertTrue(header.getMyAccountLink().isDisplayed());

    }

}
