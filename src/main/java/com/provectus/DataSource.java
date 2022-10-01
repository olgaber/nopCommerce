package com.provectus;

import com.github.javafaker.Faker;
import com.provectus.entities.User;

public class DataSource {

    public static String welcomeMessageHome = "Welcome to our store";
    public static String welcomeMessageSignIn = "Welcome, Please Sign In!";
    public static String addToCartSuccessMessage = "The product has been added to your shopping cart";
    public static String addToWishListSuccessMessage = "The product has been added to your wishlist";
    public static String registrationSuccessMessage = "Your registration completed";

    public static String email = "lucilla.cormier@gmail.com";

    public static String password = "786w7vm2";

    public User fillUserData(){
        Faker faker = new Faker();

        User user = new User();
        user.setGender(faker.random().nextBoolean());// false -> male, true -> female
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setDay(faker.random().nextInt(1, 28));
        user.setMonth(faker.random().nextInt(1, 12));
        user.setYear(faker.random().nextInt(1912, 2022));
        user.setEmail(faker.internet().emailAddress());
        user.setCompanyName(faker.company().name());
        user.setVatNumber("GB 111 111 11");
        user.setNewsletter(faker.random().nextBoolean());
        user.setPassword(faker.regexify("[a-z1-9]{8}"));
        String password = user.getPassword();
        user.setConfirmPassword(password);

        return user;
    }
}
