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
        final Pattern pattern = Pattern.compile("[-A-Za-z0-9!#$%&'*+/=?^_`{|}~]+(?:\\.[-A-Za-z0-9!#$%&'*+/=?^_`{|}~]+)*@(?:[A-Za-z0-9](?:[-A-Za-z0-9]*[A-Za-z0-9])?\\.)+[A-Za-z0-9](?:[-A-Za-z0-9]*[A-Za-z0-9])?", Pattern.CASE_INSENSITIVE);
        // Match regex against input
        final Matcher matcher = pattern.matcher(input);
        // Use results...
        return matcher.matches();
    }

    public static String email(String toVerify){
        if(isEmail(string(toVerify))) {throw new IllegalArgumentException("Invalid Email address");}
        return toVerify;
    }
}
