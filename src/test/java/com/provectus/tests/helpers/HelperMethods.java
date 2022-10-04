package com.provectus.tests.helpers;

import com.provectus.DataSource;
import com.provectus.components.CookiesNotification;
import com.provectus.components.Header;
import com.provectus.entities.User;
import com.provectus.pages.RegisterPage;
import com.provectus.pages.SignInPage;
import com.provectus.tests.BaseTest;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class HelperMethods extends BaseTest {

    public User registerUser() throws InterruptedException, ParseException {

        open("/register");

        CookiesNotification cookiesNotification = new CookiesNotification();
        cookiesNotification.acceptCookies();
        //TimeUnit.SECONDS.sleep(4);

        RegisterPage registerPage = new RegisterPage();
        DataSource dataSource = new DataSource();

        User user = dataSource.generateUser();
        registerPage.registerUser(user);

        //log out
        Header header = new Header();
        header.logOut();
        return user;
    }

    public void signInUser() throws InterruptedException {
//        open("");

//        User existingUser = registerUser();
//
//        String email = existingUser.getEmail();
//        String password = existingUser.getPassword();
//
//        System.out.println(email);
//        System.out.println(password);

        open("/login");

        CookiesNotification cookiesNotification = new CookiesNotification();
        cookiesNotification.acceptCookies();

        SignInPage signInPage = new SignInPage();
        signInPage.signIn(DataSource.email, DataSource.password);

        TimeUnit.SECONDS.sleep(4);
    }
}
