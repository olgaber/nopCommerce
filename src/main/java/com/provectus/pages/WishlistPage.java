package com.provectus.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class WishlistPage{

    private final ElementsCollection productRows = $$x("//table[@class='cart']//tbody/tr");
    private final ElementsCollection addCheckboxes = $$x("//td[@class='add-to-cart']//input");
    private final SelenideElement addToCartButton = $x("//button[@name='addtocartbutton']");

    public int getProductsQtyInWishlist(){
        return productRows.size();
    }

    public void addToCartFromWishlist(){
        Random random = new Random();
        int index = random.nextInt(addCheckboxes.size()) + 1;
        for (int i = 0; i <= addCheckboxes.size(); i++){

            if (i == index - 1) {
                String addCheckboxXpath = "//tr[" + index + "]//td[@class='add-to-cart']";
                SelenideElement addToWishlistCheckbox = $x(addCheckboxXpath);
                addToWishlistCheckbox.click();
                addToCartButton.click();
                break;
            }
        }
    }
}
