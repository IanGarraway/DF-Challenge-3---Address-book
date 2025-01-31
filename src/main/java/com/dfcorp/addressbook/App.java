package com.dfcorp.addressbook;

import java.util.Scanner;

public class App {

    private static AddressBook addDemoContacts(AddressBook theBook){
//        demo contacts generated by ChatGPT.
        theBook.addContact(new Contact("Lilyana Carter","+1-555-234-5678","lilyana.carter@examplemail.com"));
        theBook.addContact(new Contact("Kian Delgado","+1-555-876-5432","kian.delgado@samplemail.com"));
        theBook.addContact(new Contact("Amara Bennett","+1-555-345-6789","amara.bennett@demomail.com"));
        theBook.addContact(new Contact("Elias Navarro", "+1-555-987-6543", "elias.navarro@mockmail.com"));
        theBook.addContact(new Contact("Zara Hayes", "+1-555-456-7890", "zara.hayes@fakemail.com"));

        return theBook;
    }

    public static void main(String[] args){
        AddressBook theBook = new AddressBook();

        theBook = addDemoContacts(theBook);
        AddressBookInterface app = new AddressBookInterface(theBook);
        Scanner in = new Scanner(System.in);

        app.start(in);

    }
}
