package com.dfcorp.addressbook;

public class Verifyer {

    public static String string(String toVerify){
        if(toVerify.trim().isEmpty()) throw new IllegalArgumentException("Input can't be empty");
        return toVerify;
    }
}
