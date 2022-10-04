package com.provectus.tests;

import com.provectus.DataSource;
import com.provectus.components.CookiesNotification;
import com.provectus.entities.User;
import com.provectus.pages.RegisterPage;
import com.provectus.pages.RegistrationCompletedPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class SignUpTest extends BaseTest{

    @Test
    public void signUpTest() throws InterruptedException, ParseException, IOException {
        open("/register");

        File file = new File("src/main/resources/feedback_EN.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(file));

        CookiesNotification cookiesNotification = new CookiesNotification();
        cookiesNotification.acceptCookies();
        TimeUnit.SECONDS.sleep(2);

        RegisterPage registerPage = new RegisterPage();
        DataSource dataSource = new DataSource();

        User user = dataSource.generateUser();
        RegistrationCompletedPage registrationCompletedPage = registerPage.registerUser(user);

        Assert.assertEquals(registrationCompletedPage.getMessage(), properties.getProperty("registrationSuccessMessage"),
                "Registration is not successful");
    }
}
