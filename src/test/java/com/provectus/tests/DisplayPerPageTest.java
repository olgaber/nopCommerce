package com.provectus.tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.provectus.components.HorizontalMenu;
import com.provectus.pages.CategoryPage;
import com.provectus.tests.helpers.HelperMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$$x;

public class DisplayPerPageTest extends BaseTest{

    @Test
    public void checkDisplayPerPage() throws InterruptedException {
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

        //check display for 6
        Assert.assertEquals(categoryPage.getProductItems().size(), 6,
                "Incorrect number of products is displayed");

        //check display for 3
        categoryPage.getDisplaySelect().selectOption("3");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("djshdjkshdjksdjkshd");
        Assert.assertEquals(categoryPage.getProductItems().size(), 3,
                "Incorrect number of products is displayed");
    }
}
