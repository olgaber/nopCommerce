package com.provectus.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

public class HorizontalMenu {

    private final ElementsCollection menuItems = $$x("//div[@class='header-menu']/ul[@class='top-menu notmobile']/li/a");

    public ElementsCollection getMenuItems() {
        return menuItems;
    }

    public void selectRandomCategory() throws InterruptedException {

        List<String> categories = menuItems.texts();
        Random random = new Random();
        int index = random.nextInt(categories.size());
        String randomCategory = categories.get(index);

        for (SelenideElement item: menuItems){

            if(randomCategory.equals(item.getText()) ){
                item.hover();
                //TimeUnit.SECONDS.sleep(4);
                String xpathSubcategories = "//ul[@class='top-menu notmobile']//a[contains(text(), '" + item.getText() + "')]//following-sibling::ul/li/a";
                ElementsCollection subcategories = $$x(xpathSubcategories);

                List<String> subcategoriesLabels = subcategories.texts();

                if (subcategoriesLabels.size() == 0){
                    item.click();
                    break;
                }

                if (subcategoriesLabels.size() > 0){

                    int num = random.nextInt(subcategoriesLabels.size());
                    System.out.println(subcategoriesLabels.size());

                    String randomSubcategory = subcategoriesLabels.get(num);

                    for(SelenideElement subcategory : subcategories ) {
                        if (randomSubcategory.equals(subcategory.getText())) {
                            subcategory.click();
                           // TimeUnit.SECONDS.sleep(4);
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }
}
