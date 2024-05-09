import java.util.ArrayList;

public class AddressBook {
    ArrayList<Contact> contacts = new ArrayList<>();

    // in case of a load mechanic
    public AddressBook(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public AddressBook(){}

    public ArrayList<Contact> getContacts(){return contacts;}

    public void addContact(Contact newContact){
        contacts.add(newContact);
    }

    public ArrayList<Contact> searchByName(String searchName){
        ArrayList<Contact> returnList = new ArrayList<>();

        for(int i = 0; i<contacts.size(); i++){
            if(contacts.get(i).getName().equals(searchName)){ returnList.add(contacts.get(i)); }
        }
        return returnList;

    }
}
