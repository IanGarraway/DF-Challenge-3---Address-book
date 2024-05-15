package com.dfcorp.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookInterface {

    AddressBook theBook;

    public AddressBookInterface(AddressBook newBook) {
        theBook = newBook;
    }

    /* doesn't seem to do anything
    private void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
     */

    public String displayMenu() {

        return ("""
                Welcome to the DF Corp AddressBook
                Please select from the following options:
                     1. (A)dd a contact
                     2. (D)isplay all contacts
                     3. (S)earch for a contact by name
                     4. (M)odify or delete contacts
                     
                     or e to exit.
                :-""");
    }

    public String displayModMenu(){
        return """
                    AddressBook Contact Review
                    Do you wish to see :
                        1. (A)ll contacts
                        2. (S)earch by name
                        3. (E)xit to the main menu
                    """;
    }


    public StringBuilder displayContactStringBuilder(Contact contact) {
        //decided this method should be on the interface class and not on the contact class because
        //a different implementation of the interface might not need it.
        return (new StringBuilder()
                .append("Name: " + contact.getName() + "\n")
                .append("Phone: " + contact.getNumber() + "\n")
                .append("Email: " + contact.getEmail() + "\n"));
    }


    private String stringInput(String requestMessage) {
        Scanner in = new Scanner(System.in);
        System.out.print(requestMessage);

        return in.nextLine();
    }

    public String newName() {

        do {
            try {
                return Verifyer.string(stringInput("Contacts name: "));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public String newNumber() {
        do {
            try {
                return Verifyer.string(stringInput("Contacts number: "));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public String newEmail() {
        do {
            try {
                return Verifyer.email(stringInput("Contacts Email address:"));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public boolean verifyContact(Contact contactToVerify, String message) {
        do {
            String userChoice = null;
            try {
                userChoice = Verifyer.string(stringInput(displayContactStringBuilder(contactToVerify) + "\n "+message));
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter either y or n");
                userChoice = "bad";
            }

            switch (userChoice.toLowerCase()) {
                case "y":
                    return true;
                case "n":
                    return false;

            }
        } while (true);
    }


    public Contact newContactBuilder() {
        do {
            Contact newContact = new Contact(newName(), newNumber(), newEmail());
            if (verifyContact(newContact, "is this correct? [y/n] :")) {
                return newContact;
            }

        } while (true);

    }

    public void addContact() {
        theBook.addContact(newContactBuilder());
    }

    public void displayContacts(ArrayList<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println(displayContactStringBuilder(contact));
        }
    }

    public void displayAll() {
        displayContacts(theBook.getContacts());
    }

    public String getSearchName(){
        do {
            try {
                return Verifyer.string(stringInput("Name to find: "));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public void displayByName(){
        displayContacts(theBook.searchByName(getSearchName()));
    }

    public String modChoices(int position, int size){


        return ((position == 0)? "<":"<(p)revious,")+"(e)xit, (d)elete, (m)odify"+((position<(size-1)) ? ", (n)ext>":">");
    }

    public String modString(String userInput, String originalString){
        if (userInput.trim().isEmpty())return originalString;
        return userInput;
    }

    public Contact buildModContact(Contact originalContact){
        String modName = modString(stringInput("Original name: "+originalContact.getName()+" <enter new name or press enter to keep>"),originalContact.getName());
        String modNumber = modString(stringInput("Original number: "+originalContact.getNumber()+" <enter new number or press enter to keep>"),originalContact.getNumber());
        String modEmail = modString(stringInput("Original name: "+originalContact.getEmail()+" <enter new email or press enter to keep>"),originalContact.getEmail());
        return new Contact(modName,modNumber, modEmail);

    }

    public Contact modifyContact(Contact originalContact){
        do{
            Contact modContact = buildModContact(originalContact);
            if(verifyContact(modContact,"is this correct? [y/n]")) return modContact;

        }while(true);

    }

    public void contactIterator(ArrayList<Contact> contacts){
        int position = 0;

        modLoop:
        while (!contacts.isEmpty()){
            String userChoice;
            System.out.println(displayContactStringBuilder(contacts.get(position)));
            try{
                userChoice = Verifyer.string(stringInput(modChoices(position,contacts.size())));

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
                    if(verifyContact(contacts.get(position),"are you sure you wish to remove this contact? [y/n]")){
                        theBook.removeContact(contacts.get(position));
                        contacts.remove(position);
                        if(position == contacts.size()) position--;
                    }
                    break;
                case "m":
                    Contact replacementContact = modifyContact(contacts.get(position));
                    theBook.replaceContact(contacts.get(position),replacementContact);
                    contacts.set(position, replacementContact);
                    break;
                case "n":
                    if(position<contacts.size()-1) position++;
                    break;

            }
        }
    }

    public void modMenu(){
        modMenuLoop:
        do{
            String userChoice;
            try {
                userChoice = Verifyer.string(stringInput(displayModMenu()));
            }catch (IllegalArgumentException e){
                userChoice = "bad";
                System.out.println(e.getMessage());
            }
            switch (userChoice.toLowerCase()){
                case "1":
                case "a":
                    contactIterator(theBook.getContacts());
                    break;
                case "2":
                case "s":
                    contactIterator(theBook.searchByName(getSearchName()));
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

    public void menuChoice(String userChoice) {
        switch (userChoice.toLowerCase()) {
            case "a":
            case "1":
                addContact();
                break;
            case "d":
            case "2":
                displayAll();
                break;
            case "s":
            case "3":
                displayByName();
                break;
            case "m":
            case "4":
                modMenu();
                break;
            case "bad":
                break;

            default:
                System.out.println("default");

                Scanner in = new Scanner(System.in);
                in.nextLine();
        }
    }

    public void start() {
        do {
            String userChoice;


            try {
                userChoice = Verifyer.string(stringInput(displayMenu()));
            } catch (Exception e) {
                userChoice = "bad";
                System.out.println(e.getMessage());
                System.out.println("press enter to continue");
                Scanner in = new Scanner(System.in);
                in.nextLine();
            }

            if (userChoice.equalsIgnoreCase("e")) {
                break;
            }

            menuChoice(userChoice);

        } while (true);

    }
}

