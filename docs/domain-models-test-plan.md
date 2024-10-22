# Domain Models, Class Diagrams and Test Plan

## UML Class Diagram

![UML class diagram v1.](classdiagram.png)

## User story 1
as a user I want to be able to add a contact, which consists of at least a name, a phone number and an email address to my address book, so I can look them up later


### AddressBook class Tests
- [x] you can instantiate an object of class AddressBook and return the name, telephone number and email address
- [x] you can change the telephone number
- [x] you can change the email address
- [x] you can change the name of the contact

### Interface class Tests
- [x] correctly handles null strings
- [x] correctly hands empty strings
- [x] only allows the user to continue if a valid input has been entered
- [x] correctly handles invalid email address
- [x] correctly creates a contact and adds to the address book


## User story 2

As a user, I want to see all of the contacts in the address book, so I can review the details in my address book easily

### AddressBook Class Tests

- [x] you instantiate an com.dfcorp.addressbook.AddressBook and it returns and empty array list
- [x] you can add a contact to the com.dfcorp.addressbook.AddressBook and it returns a list with one item in it
- [x] if multiple contacts have been added to the addressbook, it returns all of them as a list

### Interface Class Tests
- [x] The interface will display all of the contacts in the addressbook to the screen

## User story 3

As a user I want to be able to search for a contact by name and have the results displayed, so I can find out the details I stored

### AddressBook Class Tests

- [x] entering a name will find all contacts which match that name
- [x] entering a name will find all contacts which start with that name
- [x] searchByName is not case-sensitive

### Interface Class Tests

- [x] will display all contacts com.dfcorp.addressbook.AddressBook returns
 
## User Story 4

As a user I want to be able to remove a contact from the address book, for when I no longer need to keep their details

### AddressBook Class Tests

- [x] removes the supplied contact from the arraylist

### Interface Class Tests

- [x] selecting remove contact will delete the contact from the addressbook

## User Story 5

As a user I want to be able to edit a contact, so that I can keep the details correct without having to completely re-enter a contact

### Addressbook Class Tests

- [x] passing in a AddressBook and a location will replace the contact in that location with the class

### Interface Class Tests

- [x] choosing to edit a contact will give you the opportunity to change it's details

## User Story 6

As a user, I don't want there to be two people with the same phone number, so that...actually I can't think of a good reason for this...

### Interface Class Tests

- [x] creating a new contact won't accept telephone numbers already in the addressbook
- [x] editing a contact won't accept telephone numbers already in the addressbook
- [x] editing a contact will accept the same number being re-entered

## User Story 7

As a user, I don't want there to be duplicate email addresses, so that...I can't think of a good reason for this either

### Interface Class Tests

- [x] creating a new contact won't accept email addresses already in the addressbook
- [x] editing a contact won't accept email addresses already in the addressbook
- [x] editing a contact will accept the same email addresses being re-entered


## User Story 8

As a user, I want the interface to be a console one.

### Interface class Tests

-[x] interface is entirely console driven.

# Additional Features

![UML class diagram v2.](classdiagramFunctionalComplete.png)

user stories generated with the help of ChatGPT

## User Story 9

As a user, I want to search for a contact by phone number so that I can find a contact even if I only have their phone number.

### AddressBook class tests

- [x] numberSearch returns a list of the contacts with that number
- [x] numberSearch returns partial match
- [x] numberSearch returns multiple matches
- [x] numberSearch returns an empty list if no matches found

### interface class tests

- [x] interface can search by number and display the result on the screen


## User Story 10

As a user, I want to search for a contact by email address so that I can find a contact even if I only have their email address.

### AddressBook class tests

- [x] emailSearch returns a list of the contacts with that email
- [x] emailSearch returns partial match
- [x] emailSearch returns multiple matches
- [x] emailSearch returns an empty list if no matches found

### interface class tests

- [x] interface can search by email and display the result on the screen

## User Story 11

As a user, I want to be able to sort my contacts by name, email or phone number so that I can find contacts more efficiently.

### AddressBook class tests

- [x] sortByName sorts the list in order by name 
- [x] sortByNumber sorts the list in order by number
- [x] sortByEmail sorts the list in order by email address

### Interface Class tests

- [x] sort menu which will allow you to call the sort functions

## User Story 12

As a user, I want to delete all contacts at once so that I can clear my address book quickly.

### AddressBook class tests
- [x] deleteAll deletes all contacts

### Interface class tests

- [x] user prompted with confirmation
- [x] only entering the full confirmation will delete the contacts
- 