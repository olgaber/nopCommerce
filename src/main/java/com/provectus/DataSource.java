package com.provectus;

import com.github.javafaker.Faker;
import com.provectus.entities.Gender;
import com.provectus.entities.User;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DataSource {

    //Valid credentials
    public static String email = "lucilla.cormier@gmail.com";
    public static String password = "786w7vm2";

    public DataSource() throws ParseException {
    }
    Faker faker = new Faker();
    public User generateUser() {

        Gender[] genderValues = Gender.values();
        Gender gender = genderValues[faker.random().nextInt(0, genderValues.length - 1)];

        User user = new User()
                .setGender(gender)
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setDay(getDay(date))
                .setMonth(getMonth(date))
                .setYear(getYear(date))
                .setEmail(faker.internet().emailAddress())
                .setCompanyName(faker.company().name())
                .setVatNumber("GB 111 111 11")
                .setNewsletter(faker.random().nextBoolean())
                .setPassword(faker.regexify("[a-z1-9]{8}"));
        return user;
    }
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    String dateFrom = "1-Jan-1912";
    String dateTo = "31-Dec-2022";
    Date fromDate = formatter.parse(dateFrom);
    Date toDate = formatter.parse(dateTo);
    Date date = faker.date().between(fromDate, toDate);

    public static String getYear(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(Calendar.YEAR));
    }
    public static String getMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int monthIndex = calendar.get(Calendar.MONTH);
        return getMonthName(monthIndex);
    }
    public static String getMonthName(int monthIndex) {
        return new DateFormatSymbols().getMonths()[monthIndex].toString();
    }

    public static String getDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
