package com.provectus.pages;

import com.codeborne.selenide.ElementsCollection;
import com.provectus.components.Header;

import static com.codeborne.selenide.Selenide.$$x;

public class ShoppingCartPage{

    private final ElementsCollection productRows = $$x("//table[@class='cart']//tbody/tr");
    public int getProductsQtyInCart(){
        return productRows.size();
    }

}
