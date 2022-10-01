package com.provectus.tests;

import com.provectus.DataSource;
import com.provectus.components.CookiesNotification;
import com.provectus.entities.User;
import com.provectus.pages.RegisterPage;
import com.provectus.pages.RegistrationCompletedPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class SignUpTest extends BaseTest{

    @Test
    public void signUpTest() throws InterruptedException {
        open("/register");

        CookiesNotification cookiesNotification = new CookiesNotification();
        cookiesNotification.acceptCookies();
        TimeUnit.SECONDS.sleep(2);

        RegisterPage registerPage = new RegisterPage();
        DataSource dataSource = new DataSource();

        User user = dataSource.fillUserData();
        RegistrationCompletedPage registrationCompletedPage = registerPage.registerUser(user);

        Assert.assertEquals(registrationCompletedPage.getMessage(), DataSource.registrationSuccessMessage,
                "Registration is not successful");
    }
}
