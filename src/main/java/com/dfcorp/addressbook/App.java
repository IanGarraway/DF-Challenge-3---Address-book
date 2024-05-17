package com.dfcorp.addressbook;

import java.util.Scanner;

public class App {

    public static void main(String[] args){
        AddressBook theBook = new AddressBook();
        AddressBookInterface app = new AddressBookInterface(theBook);
        Scanner in = new Scanner(System.in);

        app.start(in);

    }
}
