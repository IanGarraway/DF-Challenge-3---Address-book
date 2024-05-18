package com.dfcorp.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookInterface {

    AddressBook theBook;

    public AddressBookInterface(AddressBook newBook) {
        theBook = newBook;
    }

    public String displayMenu() {

        return ("""
                Welcome to the DF Corp AddressBook
                Please select from the following options:
                     1. (A)dd a contact
                     2. (D)isplay all contacts
                     3. (S)earch for a contact by name, phone number or email address
                     4. (M)odify or delete contacts
                     5. (O)rder your contacts
                     6. (R)emove All contacts
                
                     or e to exit.
                :-""");
    }

    public String displayModMenu(){
        return """
                    AddressBook Contact Review
                    Do you wish to see :
                        1. (A)ll contacts
                        2. (S)earch by name, phone number or email address
                        3. (E)xit to the main menu
                    """;
    }

    public String displaySearchMenu(){
        return """
        Search by:
            1. (N)ame
            2. (E)mail
            3. (T)elephone number
            4. e(X)it
            :-""";
    }

    public String displaySortMenu(){
        return """
                Do you wish to sort your contact by:
                    1. (N)ame
                    2. (E)mail
                    3. (P)hone number
                    4. e(X)it back to main menu
                :-""";
    }

    public StringBuilder displayContactStringBuilder(Contact contact) {
        //decided this method should be on the interface class and not on the contact class because
        //a different implementation of the interface might not need it.
        return (new StringBuilder()
                .append("Name: " + contact.getName() + "\n")
                .append("Phone: " + contact.getNumber() + "\n")
                .append("Email: " + contact.getEmail() + "\n"));
    }


    public String stringInput(String requestMessage, Scanner in) {

        System.out.print(requestMessage);

        return in.nextLine();
    }

    public String newName(Scanner in) {

        do {
            try {
                return Verifyer.string(stringInput("Contacts name: ",in));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public String newNumber(Scanner in) {
        do {
            try {
                String number = Verifyer.string(stringInput("Contacts number: ", in));
                if(theBook.numberExists(number)) throw new IllegalArgumentException("Number already exists");
                return number;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public String newEmail(Scanner in) {
        do {
            try {
                String email = Verifyer.email(stringInput("Contacts Email address:", in));
                if(theBook.emailExists(email)) throw new IllegalArgumentException("Email already exists");
                return email;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public boolean verifyDelete(String message, Scanner in){
        do {
            String userChoice;
            try {
                userChoice = Verifyer.string(stringInput(message, in));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                userChoice = "bad";
            }
            switch (userChoice.toLowerCase()) {
                case "y":
                case "yes":
                    return true;
                case "bad":
                    break;
                default:
                    return false;
            }
        } while (true);
    }

    public boolean verifyContact(Contact contactToVerify, String message, Scanner in) {
        do {
            String userChoice = null;
            try {
                userChoice = Verifyer.string(stringInput(displayContactStringBuilder(contactToVerify) + "\n "+message, in));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                userChoice = "bad";
            }
            switch (userChoice.toLowerCase()) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("Please enter either y or n");
            }
        } while (true);
    }

    public Contact newContactBuilder(Scanner in) {
        do {
            Contact newContact = new Contact(newName(in), newNumber(in), newEmail(in));
            if (verifyContact(newContact, "is this correct? [y/n] :", in)) {
                return newContact;
            }

        } while (true);

    }

    public void addContact(Scanner in) {
        theBook.addContact(newContactBuilder(in));
    }

    public void displayContacts(ArrayList<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println(displayContactStringBuilder(contact));
        }
    }

    public void displayAll() {
        displayContacts(theBook.getContacts());
    }

    public String getSearchTerm(String message, Scanner in){
        do {
            try {
                return Verifyer.string(stringInput(message, in));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public ArrayList<Contact> searchChoice(Scanner in){
        String userChoice;
        do{
            try{
                userChoice = Verifyer.string(stringInput(displaySearchMenu(), in));
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                userChoice = "bad";
            }

            switch (userChoice.toLowerCase()){
                case "1":
                case "n":
                    return theBook.searchByName(getSearchTerm("Name to find:-",in));
                case "2":
                case "t":
                    return theBook.searchByNumber(getSearchTerm("Telephone number to find:-",in));
                case "3":
                case "e":
                    return theBook.searchByEmail(getSearchTerm("Email to find :-",in));
                case "4":
                case "x":
                    return new ArrayList<Contact>();
                default:
                    System.out.println("Invalid option. please select from the options shown.");
            }

        }while(true);


    }


    public void displayBySearch(Scanner in){
        displayContacts(searchChoice(in));
    }

    public String modChoices(int position, int size){
        return ((position == 0)? "<":"<(p)revious,")+"(e)xit, (d)elete, (m)odify"+((position<(size-1)) ? ", (n)ext>":">");
    }

    public String modString(String userInput, String originalString, Scanner in){
        if (userInput.trim().isEmpty())return originalString;
        return userInput;
    }

    public String uniqueModNumber(String originalNumber, Scanner in){
        do{
            String newNumber = modString(stringInput("Original number: "+originalNumber+" <enter new number or press enter to keep>", in),originalNumber, in);
            if(newNumber.equals(originalNumber)||!theBook.numberExists(newNumber)){return newNumber;}
            System.out.println("Telephone Number already exists on another contact");
        }while (true);
    }

    public String uniqueModEmail(String originalEmail, Scanner in){
        do{
            String newEmail = modString(stringInput("Original name: "+originalEmail+" <enter new email or press enter to keep>", in),originalEmail, in);
            if(newEmail.equals(originalEmail)||!theBook.emailExists(newEmail)){return newEmail;}
            System.out.println("Email Address already exists on another contact");
        }while(true);
    }

    public Contact buildModContact(Contact originalContact, Scanner in){
        String modName = modString(stringInput("Original name: "+originalContact.getName()+" <enter new name or press enter to keep>", in),originalContact.getName(), in);
        String modNumber = uniqueModNumber(originalContact.getNumber(), in);
        String modEmail = uniqueModEmail(originalContact.getEmail(), in);
        return new Contact(modName,modNumber, modEmail);

    }

    public Contact modifyContact(Contact originalContact, Scanner in){
        do{
            Contact modContact = buildModContact(originalContact, in);
            if(verifyContact(modContact,"is this correct? [y/n]", in)) return modContact;
        }while(true);
    }

    public void contactIterator(ArrayList<Contact> contacts, Scanner in){
        int position = 0;

        modLoop:
        while (!contacts.isEmpty()){
            String userChoice;
            System.out.println(displayContactStringBuilder(contacts.get(position)));
            try{
                userChoice = Verifyer.string(stringInput(modChoices(position,contacts.size()), in));

            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                userChoice ="bad";
            }

            switch (userChoice.toLowerCase()){
                case "p":
                    if(position>0) position--;
                    break;
                case "e":
                    break modLoop;
                case "d":
                    if(verifyContact(contacts.get(position),"are you sure you wish to remove this contact? [y/n]", in)){
                        theBook.removeContact(contacts.get(position));
                        contacts.remove(position);
                        if(position == contacts.size()) position--;
                    }
                    break;
                case "m":
                    Contact replacementContact = modifyContact(contacts.get(position), in);
                    theBook.replaceContact(contacts.get(position),replacementContact);
                    contacts.set(position, replacementContact);
                    break;
                case "n":
                    if(position<contacts.size()-1) position++;
                    break;
            }
        }
    }

    public void sortMenu(Scanner in){
        sortMenuLoop:
        do{
            String userChoice;
            try{
                userChoice = Verifyer.string(stringInput(displaySortMenu(), in));
            } catch (IllegalArgumentException e){
                userChoice = "bad";
                System.out.println(e.getMessage());
            }

            switch (userChoice.toLowerCase()){
                case "1":
                case "n":
                    theBook.sortByName();
                    break sortMenuLoop;
                case "2":
                case "e":
                    theBook.sortByEmail();
                    break sortMenuLoop;
                case "3":
                case "p":
                    theBook.sortByNumber();
                    break sortMenuLoop;
                case "4":
                case "x":
                    break sortMenuLoop;
                default:
                    System.out.println("please select an option from the menu");
                    break;
            }

        }while(true);
    }

    public void modMenu(Scanner in){
        modMenuLoop:
        do{
            String userChoice;
            try {
                userChoice = Verifyer.string(stringInput(displayModMenu(), in));
            }catch (IllegalArgumentException e){
                userChoice = "bad";
                System.out.println(e.getMessage());
            }
            switch (userChoice.toLowerCase()){
                case "1":
                case "a":
                    contactIterator(theBook.getContacts(), in);
                    break;
                case "2":
                case "s":
                    contactIterator(searchChoice(in), in);
                    break;
                case "3":
                case "e":
                    break modMenuLoop;
                case "bad":
                    break;
                default:
                    System.out.println("Invalid option, please try again");
            }
        }while(true);
    }

    public void menuChoice(String userChoice, Scanner in) {
        switch (userChoice.toLowerCase()) {
            case "a":
            case "1":
                addContact(in);
                break;
            case "d":
            case "2":
                displayAll();
                break;
            case "s":
            case "3":
                displayBySearch(in);
                break;
            case "m":
            case "4":
                modMenu(in);
                break;
            case "o":
            case "5":
                sortMenu(in);
                break;
            case "6":
            case "r":
                if(verifyDelete("Delete all contacts? [y to confirm]",in)&&verifyDelete("This is permanent. are you sure? [y to delete all]",in)) {theBook.deleteAll();}
                break;
            case "bad":
                break;

            default:
                System.out.println("default");

                in.nextLine();
        }
    }

    public void start(Scanner in) {
         //this to me feels wrong, but I can see no other way to mock the input for testing
        do {
            String userChoice;

            try {
                userChoice = Verifyer.string(stringInput(displayMenu(), in));
            } catch (Exception e) {
                userChoice = "bad";
                System.out.println(e.getMessage());
                System.out.println("press enter to continue");

                in.nextLine();
            }

            if (userChoice.equalsIgnoreCase("e")) {
                break;
            }
            menuChoice(userChoice, in);
        } while (true);
    }
}

