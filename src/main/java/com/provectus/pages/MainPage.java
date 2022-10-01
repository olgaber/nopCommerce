package com.provectus.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final SelenideElement welcomeMessage = $x("//div[@class='page home-page']//h2[contains(text(), 'Welcome to our store')]");

    public String getWelcomeMessageText(){
        return  welcomeMessage.getText();
    }



}
