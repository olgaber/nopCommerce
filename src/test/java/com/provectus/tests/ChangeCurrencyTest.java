package com.provectus.tests;

import com.provectus.components.HorizontalMenu;
import com.provectus.tests.helpers.HelperMethods;
import org.testng.annotations.Test;

public class ChangeCurrencyTest {

    @Test
    public void changeCurrencyTest() throws InterruptedException {

        HelperMethods helperMethods = new HelperMethods();
        helperMethods.signInUser();

        HorizontalMenu horizontalMenu = new HorizontalMenu();
    }
}
