package com.dfcorp.addressbook;

import java.util.ArrayList;

public class AddressBook {
    private ArrayList<Contact> contacts = new ArrayList<>();

    /*// in case of a load mechanic
    public AddressBook(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }*/

    public AddressBook(){}

    //Add remove and replace functions

    public void addContact(Contact newContact){
        contacts.add(newContact);

    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public void replaceContact(Contact original, Contact replacement){
        contacts.set(contacts.indexOf(original),replacement);
    }

    //return contacts functions

    public ArrayList<Contact> getContacts(){return new ArrayList<Contact>(contacts);}

    public ArrayList<Contact> searchByName(String searchName){
        ArrayList<Contact> returnList = new ArrayList<>();

        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().startsWith(searchName.toLowerCase())) {
                returnList.add(contact);
            }
        }
        return returnList;
    }

    public ArrayList<Contact> searchByNumber(String searchNumber){
        ArrayList<Contact> returnList = new ArrayList<>();

        for (Contact contact : contacts) {
            if (contact.getNumber().toLowerCase().contains(searchNumber.toLowerCase())) {
                returnList.add(contact);
            }
        }
        return returnList;
    }
    public ArrayList<Contact> searchByEmail(String searchEmail){
        ArrayList<Contact> returnList = new ArrayList<>();

        for (Contact contact : contacts) {
            if (contact.getEmail().toLowerCase().contains(searchEmail.toLowerCase())) {
                returnList.add(contact);
            }
        }
        return returnList;
    }

    //Sort functions

    public void sortByName(){
        contacts.sort((Contact c1, Contact c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

    }



    //Verification functions

    public boolean numberExists(String number){
        boolean numberExists = false;
        for (Contact contact : contacts) {
            if(contact.getNumber().equals(number)){
                numberExists = true;
                break;
            }
        }
        return numberExists;
    }

    public boolean emailExists(String email){
        boolean emailExists = false;
        for (Contact contact : contacts) {
            if(contact.getEmail().equals(email)){
                emailExists = true;
                break;
            }
        }
        return emailExists;
    }


}
