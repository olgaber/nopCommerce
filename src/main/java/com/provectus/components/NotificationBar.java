package com.provectus.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class NotificationBar {

    private  final SelenideElement notificationBar = $x("//div[@id='bar-notification']//p");
    private final SelenideElement closeNotificationButton = $x("//div[@id='bar-notification']//span");

    public SelenideElement getNotificationBar() {
        return notificationBar;
    }

    public String getNotificationText(){
        return notificationBar.text();
    }

    public void closeNotification(){
        closeNotificationButton.click();
    }

}
