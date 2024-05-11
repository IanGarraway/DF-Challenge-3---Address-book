package com.dfcorp.addressbook;

import java.util.Scanner;

public class AddressBookInterface {

    AddressBook theBook = new AddressBook();

    private void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void displayMenu(){
        clearScreen();
        System.out.println("Welcome to the DF Corp AddressBook");
        System.out.println("Please select from the following options: ");
        System.out.println("     1. (A)dd a contact");
        System.out.println("     2. (D)isplay all contacts");
        System.out.println("     3. (S)earch for a contact by name");
        System.out.println("     4. (E)dit or delete contacts");
    }

    public String stringVerify(String toVerify){
        if(toVerify.trim().isEmpty()) throw new IllegalArgumentException("Input can't be empty");
        return toVerify;
    }

    public String stringInput(String requestMessage){
        Scanner in = new Scanner(System.in);
        System.out.println(requestMessage);

        return stringVerify(in.nextLine());
    }

    public void start(){
        do{
            String userChoice;

            displayMenu();
            try{
                userChoice = stringInput(":-");
            }
            catch (Exception e){
                System.out.println(e.toString());
                System.out.println("press enter to continue");
                Scanner in = new Scanner(System.in);
                in.nextLine();

            }
        }while(true);

    }

}
