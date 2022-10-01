package com.provectus.tests;

import com.codeborne.selenide.SelenideElement;
import com.provectus.components.HorizontalMenu;
import com.provectus.pages.CategoryPage;
import com.provectus.pages.ProductPage;
import com.provectus.tests.helpers.HelperMethods;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DownloadSampleTest extends BaseTest{
    @Test
    public void downloadSampleTest() throws InterruptedException {
        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signInUser();

        HorizontalMenu horizontalMenu = new HorizontalMenu();
        for (SelenideElement item : horizontalMenu.getMenuItems()){
            if (item.getText().equals("Digital downloads")){
                item.click();
                break;
            }
        }

        CategoryPage categoryPage = new CategoryPage();

        for (SelenideElement item: categoryPage.getProductItems()){
            String productName = item.find(By.cssSelector(".product-title")).getText();
            if(productName.equals("Night Visions")){
                SelenideElement productTitle = item.find(By.cssSelector("h2.product-title > a"));
                ProductPage productPage = categoryPage.openProduct(productTitle);
                TimeUnit.SECONDS.sleep(4);
                productPage.downloadSample();
                break;
            }
        }
    }
}



