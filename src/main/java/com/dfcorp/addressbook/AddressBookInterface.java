package com.dfcorp.addressbook;

import java.util.Scanner;

public class AddressBookInterface {

    AddressBook theBook = new AddressBook();

    public AddressBookInterface(AddressBook newBook){
        theBook = newBook;
    }
    /* doesn't seem to do anything
    private void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
     */

    public String displayMenu(){

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

    public StringBuilder displayContactStringBuilder(Contact contact){
        //decided this method should be on the interface class and not on the contact class because
        //a different implementation of the interface might not need it.
        return (new StringBuilder()
                .append("Name: "+contact.getName()+"\n")
                .append("Phone: "+contact.getNumber()+"\n")
                .append("Email: "+contact.getEmail()+"\n"));
    }



    public String stringInput(String requestMessage){
        Scanner in = new Scanner(System.in);
        System.out.print(requestMessage);

        return in.nextLine();
    }

    public void menuChoice(String userChoice){
        switch (userChoice.toLowerCase()){
            case "a":
            case "1":
                System.out.println("Add user");
                break;
            case "d":
            case "2":
                System.out.println("Display all contacts");
                break;
            case "s":
            case "3":
                System.out.println("Search by Name");
                break;
            case "m":
            case "4":
                System.out.println("edit contacts");
                break;
            case "bad":
                break;

            default:
                System.out.println("default");

                Scanner in = new Scanner(System.in);
                in.nextLine();
        }
    }

    public void start(){
        do{
            String userChoice;


            try{
                userChoice = Verifyer.string(stringInput(displayMenu()));
            }
            catch (Exception e){
                userChoice = "bad";
                System.out.println(e.getMessage());
                System.out.println("press enter to continue");
                Scanner in = new Scanner(System.in);
                in.nextLine();
            }

            if (userChoice.equalsIgnoreCase("e")){ break;}

            menuChoice(userChoice);

        }while(true);

    }

}
