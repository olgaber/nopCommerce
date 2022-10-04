package com.provectus.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SignInPage{

    public final SelenideElement welcomeMessage = $x("//div[@class='page-title']/h1");
    private final SelenideElement emailInput = $("input#Email");
    private final SelenideElement passwordInput = $("input#Password");
    private final SelenideElement loginButton = $x("//button[contains(text(), 'Log in')]");

    public String getWelcomeMessage(){
        return welcomeMessage.getText();
    }

    public void signIn(String email, String password){
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
    }



}
