package com.provectus.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CookiesNotification {

    private final SelenideElement cookiesModal = $("div#eu-cookie-bar-notification");
    private final SelenideElement okButton = $("button#eu-cookie-ok");

    public SelenideElement getModal(){
        return cookiesModal;
    }

    public void acceptCookies(){
        okButton.click();
    }
}
