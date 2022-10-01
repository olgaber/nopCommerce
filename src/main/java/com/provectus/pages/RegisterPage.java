package com.provectus.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.provectus.entities.User;

import static com.codeborne.selenide.Selenide.*;

public class RegisterPage{

    private final SelenideElement femaleRadio = $("input#gender-male");
    private final SelenideElement maleRadio = $("input#gender-female");
    private final SelenideElement firstNameInput = $("input#FirstName");
    private final SelenideElement lastNameInput = $("input#LastName");
    private final SelenideElement monthDropdown = $x("//select[@name='DateOfBirthMonth']");
    private final ElementsCollection dayDropdownOptions = $$x("//select[@name='DateOfBirthDay']/option");
    private final ElementsCollection yearDropdownOptions = $$x("//select[@name='DateOfBirthYear']/option");

    private final SelenideElement emailInput = $("input#Email");
    private final SelenideElement companyNameInput = $("input#Company");
    private final SelenideElement vatNumberInput = $("input#VatNumber");
    private final SelenideElement newsletterCheckbox = $("input#Newsletter");
    private final SelenideElement passwordInput = $("input#Password");
    private final SelenideElement confirmPasswordInput = $("input#ConfirmPassword");

    private final SelenideElement registerButton = $("button#register-button");

   public RegisterPage selectGender(Boolean gender){

       if(gender == true)
           femaleRadio.click();
       else{
           maleRadio.click();
       }
       return this;
   }

    public RegisterPage fillFirstName(String firstName){
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public RegisterPage fillLastName(String lastName){
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public RegisterPage selectDay(int day){
        String dayString = String.valueOf(day);
        for (SelenideElement dayOption : dayDropdownOptions){
            String text = dayOption.getText();
            if (text.equals(dayString)){
                dayOption.click();
                break;
            }
        }
        return this;
    }

    public RegisterPage selectMonth(int month) {
        System.out.println(month);
        monthDropdown.click();
        monthDropdown.selectOption(month);
        monthDropdown.click();
       return this;
    }

    public RegisterPage selectYear(int year){
        String yearString = String.valueOf(year);
        for (SelenideElement yearOption : yearDropdownOptions){
            String text = yearOption.getText();
            if (text.equals(yearString)){
                yearOption.click();
                break;
            }
        }
        return this;
    }

    public RegisterPage fillEmail(String email){
       emailInput.clear();
       emailInput.sendKeys(email);
       return this;
    }

    public RegisterPage fillCompanyName(String companyName){
       companyNameInput.clear();
       companyNameInput.sendKeys(companyName);
       return this;
    }

    public RegisterPage fillVatNumber(String vatNumber){
        System.out.println(vatNumber);
       vatNumberInput.clear();
       vatNumberInput.sendKeys(vatNumber);
       return this;
    }

    public RegisterPage setNewsletterCheckbox(boolean state){
       if(state){
           newsletterCheckbox.click();
       }
       return this;
    }

    public RegisterPage setPassword(String password){
       passwordInput.clear();
       passwordInput.sendKeys(password);
       return this;
    }

    public RegisterPage confirmPassword(String password){
       confirmPasswordInput.clear();
       confirmPasswordInput.sendKeys(password);
       return this;
    }

    public RegistrationCompletedPage register(){
       registerButton.click();
       return new RegistrationCompletedPage();
    }

    public RegistrationCompletedPage registerUser(User user) throws InterruptedException {
       return selectGender(user.getGender())
               .fillFirstName(user.getFirstName())
               .fillLastName(user.getLastName())
               .selectDay(user.getDay())
               .selectMonth(user.getMonth())
               .selectYear(user.getYear())
               .fillEmail(user.getEmail())
               .fillCompanyName(user.getCompanyName())
               .fillVatNumber(user.getVatNumber())
               .setNewsletterCheckbox(user.getNewsletter())
               .setPassword(user.getPassword())
               .confirmPassword(user.getConfirmPassword())
               .register();
   }
}
