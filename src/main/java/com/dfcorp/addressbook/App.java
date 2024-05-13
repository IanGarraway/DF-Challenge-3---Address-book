package com.dfcorp.addressbook;

public class App {

    public static void main(String[] args){
        AddressBook theBook = new AddressBook();
        AddressBookInterface app = new AddressBookInterface(theBook);

        app.start();

    }
}
