package com.provectus.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.provectus.components.Header;
import com.provectus.components.HorizontalMenu;
import com.provectus.components.NotificationBar;
import com.provectus.pages.CategoryPage;
import com.provectus.pages.ProductPage;
import com.provectus.tests.helpers.HelperMethods;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class GiftCardErrorTest extends BaseTest {

    @Test
    public void checkGiftCardError() throws InterruptedException, IOException {

        File file = new File("src/main/resources/feedback_EN.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(file));

        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signInUser();
        NotificationBar notificationBar = new NotificationBar();

        HorizontalMenu horizontalMenu = new HorizontalMenu();
        for (SelenideElement item : horizontalMenu.getMenuItems()){
            if (item.getText().equals("Gift Cards")){
                item.click();
                break;
            }
        }

        CategoryPage categoryPage = new CategoryPage();
        Random random = new Random();
        int index = random.nextInt(categoryPage.getProductItems().size());
        System.out.println(index);
        int count = 0;
        String selectedProduct = "";

        for (SelenideElement item: categoryPage.getProductItems()){

            if (count == index) {
                SelenideElement productName = item.find(By.cssSelector(".product-title > a"));
                selectedProduct = productName.getText();
                productName.scrollIntoView(false).click();
                break;
            }
            count++;

        }
        System.out.println(selectedProduct);

        // Empty recipient's name

        ProductPage productPage = new ProductPage();
        productPage.getAddToCartButton()
                .shouldBe(Condition.interactable)
                .scrollIntoView(true)
                .click();
        TimeUnit.SECONDS.sleep(3);

        notificationBar.getNotificationBar().shouldBe(Condition.visible);
        Assert.assertEquals(notificationBar.getNotificationText(), properties.getProperty("recipientNameError"),
                "The messages should be the same");

        productPage.closeError();


       // Empty sender's name
        actions().moveToElement(productPage.getRecipientName());
        productPage.fillRecipientName(properties.getProperty("recipientName"));

        TimeUnit.SECONDS.sleep(4);

        productPage.clearSenderName();

        productPage.getAddToCartButton()
                .scrollIntoView(true)
                .click();

        notificationBar.getNotificationBar().shouldBe(Condition.visible);
        Assert.assertEquals(notificationBar.getNotificationText(), properties.getProperty("senderNameError"),
                "The messages should be the same");

        productPage.closeError();
        // Enter valid recipient's and sender's names
        Selenide.refresh();
        TimeUnit.SECONDS.sleep(4);

        productPage.fillRecipientName(properties.getProperty("recipientName"));
        productPage.fillSenderName(properties.getProperty("senderName"));
        productPage.getAddToCartButton().click();

        // Success message
        notificationBar.getNotificationBar().shouldBe(Condition.visible);
        Assert.assertEquals(notificationBar.getNotificationText(), properties.getProperty("addToCartSuccessMessage"),
                "The messages should be the same");
        notificationBar.closeNotification();

        $("h1").scrollIntoView(false);

        Header header = new Header();
        header.goToShoppingCartPage();
        TimeUnit.SECONDS.sleep(4);
    }
}
