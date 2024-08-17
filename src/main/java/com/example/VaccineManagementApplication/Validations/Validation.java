package com.example.VaccineManagementApplication.Validations;

import lombok.experimental.UtilityClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class Validation {

    public static boolean validateEmail(String email) {
        String pattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean validateContactNo(String mobile) {
        String pattern = "(0|91)?[7-9][0-9]{9}";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(mobile);
        return m.matches();
    }

    public static boolean validatePanNumber(String panNo) {
        String pattern = "[A-Z]{5}[0-9]{4}[A-Z]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(panNo);
        return m.matches();
    }
}
