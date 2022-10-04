package com.provectus.tests;

import com.provectus.DataSource;
import com.provectus.components.Header;
import com.provectus.components.HorizontalMenu;
import com.provectus.pages.CategoryPage;
import com.provectus.pages.ShoppingCartPage;
import com.provectus.pages.WishlistPage;
import com.provectus.tests.helpers.HelperMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AddProductFromWishlistToCartTest extends BaseTest {

    @Test
    public void addProductFromWishListToCartTest() throws InterruptedException, IOException {

        int qty = 2;

        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signInUser();

        HorizontalMenu horizontalMenu = new HorizontalMenu();
        CategoryPage categoryPage = new CategoryPage();
        Header header = new Header();

        File file = new File("src/main/resources/feedback_EN.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(file));

        // Add two products to cart
        for (int i = 0; i < qty; i++){
            horizontalMenu.selectRandomCategory();
            categoryPage.addItemToCart();
            Assert.assertEquals(categoryPage.getMessage(), properties.getProperty("addToCartSuccessMessage"),
            "The product hasn't been added to shopping cart");
            categoryPage.closeFeedback();
        }

        // Go to cart and count products
        header.goToShoppingCartPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        int initialProductsQtyInCart = shoppingCartPage.getProductsQtyInCart();

        // Add two products to wishlist
        int countWishlist = 0;
        for(int i = 0; i < qty; i++){
            horizontalMenu.selectRandomCategory();
            categoryPage.addItemToWishlist();
            Assert.assertEquals(categoryPage.getMessage(), properties.getProperty("addToWishListSuccessMessage"),
                    "The product hasn't been added to your wishlist");
            countWishlist++;
            categoryPage.closeFeedback();
        }

        // Go to wishlist All products that were added to wishlist should be displayed
        header.goToWishlistPage();
        WishlistPage wishlistPage = new WishlistPage();
        Assert.assertEquals(countWishlist, wishlistPage.getProductsQtyInWishlist(),
                "Quantity of products added to wishlist differs from the expected quantity");

        //Add product from Wishlist to Cart
        wishlistPage.addToCartFromWishlist();
        TimeUnit.SECONDS.sleep(4);

        //Check the number of products in Shopping cart is increased by one
        header.goToShoppingCartPage();
        int updatedProductsQtyInCart = shoppingCartPage.getProductsQtyInCart();
        Assert.assertEquals(updatedProductsQtyInCart, initialProductsQtyInCart + 1,
                "The product hasn't been added from Wishlist to Cart");
    }
}
