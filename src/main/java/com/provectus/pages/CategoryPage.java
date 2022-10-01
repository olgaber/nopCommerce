package com.provectus.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class CategoryPage{

    private final ElementsCollection productItems = $$x("//div[@class='product-item']");
    private final SelenideElement message = $x("//div[@class='bar-notification success']/p");
    private  final SelenideElement feedbackClose = $x("//div[@class='bar-notification success']/span");
    private final SelenideElement displaySelect = $("select#products-pagesize");
    private  final  SelenideElement nextButton = $x("//li[@class='next-page']");
    private  final SelenideElement title = $x("//div[@class='page-title']/h1");

    public SelenideElement getTitle(){
        return title;
    }

    public SelenideElement getNextButton() {
        return nextButton;
    }

    public SelenideElement getDisplaySelect(){
        return displaySelect;
    }

    public String getMessage(){
        return message.getText();
    }
    public void closeFeedback(){
        feedbackClose.click();
    }

    public ElementsCollection getProductItems() {
        return productItems;
    }
    public void addItemToCart() {

        Random random = new Random();
        int index = random.nextInt(productItems.size()) + 1;

        for (int i = 0; i <=  productItems.size(); i++){

            if (i == index - 1) {
                String addToCartXpath = "//div[@class='item-box'][" + index + "]//button[@class='button-2 product-box-add-to-cart-button']";
                SelenideElement addToCartButton = $x(addToCartXpath);
                addToCartButton.scrollIntoView(true).click();
                break;
            }
        }
    }

    public void addItemToWishlist(){

        Random random = new Random();
        int index = random.nextInt(productItems.size()) + 1;

        for (int i = 0; i <=  productItems.size(); i++){

            if (i == index - 1) {
                String addToCartXpath = "//div[@class='item-box'][" + index + "]//button[@class='button-2 add-to-wishlist-button']";
                SelenideElement addToCartButton = $x(addToCartXpath);
                addToCartButton.scrollIntoView(true).click();
                break;
            }
        }
    }
    public ProductPage openProduct(SelenideElement title){

        title.click();
        return new ProductPage();

    }

}
