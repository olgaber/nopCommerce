package com.provectus.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.provectus.components.HorizontalMenu;
import com.provectus.pages.CategoryPage;
import com.provectus.tests.helpers.HelperMethods;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$$x;

public class PaginationTest extends BaseTest{

    @Test
    public void checkPaginationTest() throws InterruptedException {

        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signInUser();

        //Go to Computers -> Notebooks
        HorizontalMenu horizontalMenu = new HorizontalMenu();

        for (SelenideElement item : horizontalMenu.getMenuItems()){
            if (item.getText().equals("Computers")){
                item.hover();
                String xpathSubcategories = "//ul[@class='top-menu notmobile']//a[contains(text(), '" + item.getText() + "')]//following-sibling::ul/li/a";
                ElementsCollection subcategories = $$x(xpathSubcategories);
                for (SelenideElement subcategory: subcategories){
                    if (subcategory.getText().equals("Notebooks")){
                        subcategory.click();
                        break;
                    }
                }
                break;
            }
        }

        CategoryPage categoryPage = new CategoryPage();

        //check display for 3
        categoryPage.getDisplaySelect().selectOption("3");
        TimeUnit.SECONDS.sleep(2);

        List<String> productsList1 = new ArrayList<>();

        //save products to list on page1
        for (SelenideElement item: categoryPage.getProductItems()){
            String productName = item.find(By.cssSelector(".product-title")).getText();
            productsList1.add(productName);
        }
        System.out.println(productsList1);

        categoryPage.getNextButton()
                .shouldBe(Condition.interactable)
                .scrollIntoView(false)
                .click();

        TimeUnit.SECONDS.sleep(5);

        // save products to list on page2
        List<String> productsList2 = new ArrayList<>();

        //save products to list
        for (SelenideElement item: categoryPage.getProductItems()){
            String productName = item.find(By.cssSelector(".product-title")).getText();
            productsList2.add(productName);
        }
        System.out.println(productsList2);

        //compare two lists
        Assert.assertNotEquals(productsList1, productsList2, "The lists should be different");

    }
}
