package com.provectus.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {

    private final SelenideElement downloadSampleButton = $x("//div[@class='download-sample']/a");
    private  final SelenideElement addToCartButton = $x("//button[contains(text(), 'Add to cart')]");
    private  final SelenideElement barNotificationError = $("div#bar-notification");

    private final SelenideElement recipientName = $x("//input[@class='recipient-name']");
    private final SelenideElement senderName = $x("//input[@class='sender-name']");
    private final SelenideElement closeErrorButton = $x("//div[@id='bar-notification']//span");

    public SelenideElement getCloseErrorButton() {
        return closeErrorButton;
    }

    public SelenideElement getRecipientName() {
        return recipientName;
    }

    public SelenideElement getSenderName() {
        return senderName;
    }

    public SelenideElement getBarNotificationError() {
        return barNotificationError;
    }

    public void downloadSample(){
        downloadSampleButton.click();
    }

    public SelenideElement getAddToCartButton() {
        return addToCartButton;
    }

    public void fillRecipientName(String name){
        recipientName.scrollIntoView(true).sendKeys(name);
    }
    public void clearSenderName(){
        senderName.scrollIntoView(true).clear();
    }

    public void fillSenderName(String name){
        clearSenderName();
        senderName.sendKeys(name);

    }

    public void closeError(){
        closeErrorButton.click();
    }
}
