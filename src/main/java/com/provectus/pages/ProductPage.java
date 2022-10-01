package com.provectus.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {

    private final SelenideElement downloadSampleButton = $x("//div[@class='download-sample']/a");

    public void downloadSample(){
        downloadSampleButton.click();
    }

}
