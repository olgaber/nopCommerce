package com.provectus.components;

import com.codeborne.selenide.SelenideElement;
import com.provectus.pages.RegisterPage;
import com.provectus.pages.ShoppingCartPage;
import com.provectus.pages.SignInPage;
import com.provectus.pages.WishlistPage;

import static com.codeborne.selenide.Selenide.$x;

public class Header{

    private final SelenideElement registerLink = $x("//div[@class='header-links']//a[contains(text(), 'Register')]");
    private final SelenideElement logInLink = $x("//div[@class='header-links']//a[contains(text(), 'Log in')]");
    private final SelenideElement wishlistLink = $x("//div[@class='header-links']//a[contains(text(), 'Wishlist')]");
    private final SelenideElement shoppingCartLink = $x("//div[@class='header-links']//a[contains(text(), 'Shopping cart')]");
    private final SelenideElement logoutLink = $x("//div[@class='header-links']//a[contains(text(), 'Log out')]");
    private final SelenideElement myAccountLink = $x("//div[@class='header-links']//a[contains(text(), 'My account')]");

    public SelenideElement getRegisterLink(){
        return registerLink;
    }

    public SelenideElement getMyAccountLink() {
        return myAccountLink;
    }

    public SelenideElement getLogInLink(){
        return logInLink;
    }

    public SelenideElement getWishlistLink() {
        return wishlistLink;
    }

    public SelenideElement getShoppingCartLink() {
        return shoppingCartLink;
    }

    public SelenideElement getLogoutLink() {
        return logoutLink;
    }

    public RegisterPage goToRegistrationPage(){
        registerLink.click();
        return new RegisterPage();
    }

    public SignInPage goToSignInPage(){
        logInLink.click();
        return new SignInPage();
    }

    public WishlistPage goToWishlistPage(){
        wishlistLink.click();
        return new WishlistPage();
    }

    public ShoppingCartPage goToShoppingCartPage(){
        shoppingCartLink.click();
        return new ShoppingCartPage();
    }

    public void logOut(){
        logoutLink.click();
    }


}
