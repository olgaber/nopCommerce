package com.provectus.entities;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private Gender gender;
    private String firstName;
    private String lastName;
    private String month;
    private String day;
    private String year;
    private String email;
    private String companyName;
    private String vatNumber;
    private Boolean newsletter;
    private String password;
    private String confirmPassword;
}
