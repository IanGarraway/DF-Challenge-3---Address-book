package com.dfcorp.addressbook;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verifyer {

    public static String string(String toVerify){
        if(toVerify.trim().isEmpty()) throw new IllegalArgumentException("Input can't be empty");
        return toVerify;
    }

    public static boolean isEmail(final String input) {
        // Compile regular expression
        final Pattern pattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        // Match regex against input
        // Use results...
        return pattern.matcher(input).matches();
    }

    public static String email(String toVerify){
        if(!isEmail(string(toVerify))) {throw new IllegalArgumentException("Invalid Email address");}
        return toVerify;
    }
}
