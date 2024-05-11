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

    public void menuChoice(String userChoice){
        switch (userChoice.toLowerCase()){
            case "a":
            case "1":
                System.out.println("Add user");
                break;
            case "b":
            case "2":
                System.out.println("Display all contacts");
                break;
            case "c":
            case "3":
                System.out.println("Search by Name");
                break;
            case "d":
            case "4":
                System.out.println("edit contacts");
                break;

            default:
                System.out.println("default");

                Scanner in = new Scanner(System.in);
                in.nextLine();
        }
    }

    public void start(){
        mainLoop:
        do{
            String userChoice;

            displayMenu();
            try{
                userChoice = stringInput(":-");
            }
            catch (Exception e){
                userChoice = "bad";
                System.out.println(e.toString());
                System.out.println("press enter to continue");
                Scanner in = new Scanner(System.in);
                in.nextLine();
            }

            if (userChoice.equalsIgnoreCase("e")){ break mainLoop;}

            menuChoice(userChoice);

        }while(true);

    }

}
