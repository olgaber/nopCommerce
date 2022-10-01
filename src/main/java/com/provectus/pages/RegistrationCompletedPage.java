package com.provectus.pages;

import com.codeborne.selenide.SelenideElement;
import com.provectus.components.Header;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationCompletedPage {

    private final SelenideElement message = $x("//div[@class='result']");

    public String getMessage(){
        return message.getText();
    }

}
