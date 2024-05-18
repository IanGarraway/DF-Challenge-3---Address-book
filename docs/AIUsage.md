# AI Usage as part of the project
awaiting access to copilot, all AI usage done through chatgpt webchats

## AI usage in core features

ChatGPT was used to get the necessary text to add mockito to the project as it wasn't showing on the list of generatable
dependencies. The code offered was out of date though, and replaced with code from mvnrepository.com


Used to confirm there wasn't a better way to clear the screen then System.out.print("\033[H\033[2J");
System.out.flush();



me: if i passed an ArrayList into another class, is there any way to stop that class being able to change the data of that arraylist?

chatgpt:     Pass an Unmodifiable List: Instead of passing the original ArrayList, you can pass an unmodifiable view of the list using Collections.unmodifiableList() method. This prevents the other class from modifying the list.

java

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Main {
public static void main(String[] args) {
ArrayList<String> originalList = new ArrayList<>();
originalList.add("Item 1");
originalList.add("Item 2");

        OtherClass otherClass = new OtherClass(Collections.unmodifiableList(originalList));
        // Attempt to modify the list in the other class
        // otherClass.modifyList(); // This will throw UnsupportedOperationException
    }
}

class OtherClass {
private List<String> readOnlyList;

    public OtherClass(List<String> readOnlyList) {
        this.readOnlyList = readOnlyList;
    }
    
    public void modifyList() {
        // Attempting to modify the list will throw UnsupportedOperationException
        readOnlyList.add("New Item");
    }
}

    Defensive Copy: Instead of passing the original ArrayList, pass a copy of it to the other class. This way, any modifications made in the other class won't affect the original list.

java

import java.util.ArrayList;

public class Main {
public static void main(String[] args) {
ArrayList<String> originalList = new ArrayList<>();
originalList.add("Item 1");
originalList.add("Item 2");

        OtherClass otherClass = new OtherClass(new ArrayList<>(originalList));
        // Modifications in otherClass won't affect originalList
        // otherClass.modifyList(); // You can safely call this
    }
}

class OtherClass {
private ArrayList<String> internalList;

    public OtherClass(ArrayList<String> list) {
        this.internalList = list;
    }
    
    public void modifyList() {
        // You can modify the list here
        internalList.add("New Item");
    }
}

Both approaches have their pros and cons. Using an unmodifiable list is safer but if you need to modify the list within the original class, defensive copying might be more suitable. Choose the approach based on your specific requirements.

--
I went with the defensive programming technique and modified addressbook to return a new arraylist made up on the contacts instead of directly returning the contacts list


# Additional Features
## Prompt:
i've written a program which meets these requirements: The user should be able to add a contact to the address book
A contact should have at least a name, phone number and email address
The user should be able to search for a contact by name and have the results displayed
The user should be able to remove a contact from the address book
The user should be able to edit a contact's details
Duplicate phone numbers or email addresses should not be allowed, i.e. no two contacts should have the same phone number or email address
The user should be able to view all contacts in the address book
The user should be using a console interface to interact with the application.
I've been asked to add these additional features:
n addition to these core features, the client has the following requests for functionality that they would like to see in the application if you have time:

The user should be able to search for a contact by phone number and have the results displayed
The user should be able to search for a contact by email address and have the results displayed
The user should be able to search for a contact by name, phone number or email address and have the results displayed in alphabetical order
The user should be able to delete all contacts at once, confirming that they want to do this before proceeding
can you give me a list of appropriate user stories

## response:

Certainly! Here are the user stories that capture both the core requirements and the additional features requested by the client:

### Core Features

1. **Add Contact**
    - As a user, I want to add a new contact with a name, phone number, and email address so that I can save the contact details for future reference.
    - Acceptance Criteria:
        - The contact must have a name, phone number, and email address.
        - The phone number and email address must be unique.

2. **Search Contact by Name**
    - As a user, I want to search for a contact by name so that I can quickly find and view their details.
    - Acceptance Criteria:
        - The search results should display matching contacts.

3. **Remove Contact**
    - As a user, I want to remove a contact from the address book so that I can keep my address book up to date.
    - Acceptance Criteria:
        - The contact should be removed from the address book.

4. **Edit Contact**
    - As a user, I want to edit a contact's details so that I can update their information if it changes.
    - Acceptance Criteria:
        - The user should be able to modify the name, phone number, and email address.
        - The phone number and email address must remain unique.

5. **View All Contacts**
    - As a user, I want to view all contacts in my address book so that I can see everyone I have saved.
    - Acceptance Criteria:
        - The list should display all saved contacts.

### Additional Features

6. **Search Contact by Phone Number**
    - As a user, I want to search for a contact by phone number so that I can find a contact even if I only have their phone number.
    - Acceptance Criteria:
        - The search results should display matching contacts.

7. **Search Contact by Email Address**
    - As a user, I want to search for a contact by email address so that I can find a contact even if I only have their email address.
    - Acceptance Criteria:
        - The search results should display matching contacts.

8. **Search Contact by Any Field**
    - As a user, I want to search for a contact by name, phone number, or email address and have the results displayed in alphabetical order so that I can find contacts more efficiently.
    - Acceptance Criteria:
        - The search results should be sorted alphabetically by name.

9. **Delete All Contacts**
    - As a user, I want to delete all contacts at once so that I can clear my address book quickly.
    - Acceptance Criteria:
        - The user must confirm before all contacts are deleted.
        - All contacts should be removed upon confirmation.

### Example User Story Format

**Title**: Add Contact

**As a**: user

**I want to**: add a new contact with a name, phone number, and email address

**So that**: I can save the contact details for future reference

**Acceptance Criteria**:
1. The contact must have a name, phone number, and email address.
2. The phone number and email address must be unique.

By organizing the requirements into user stories, you can ensure that each feature is implemented in a user-centric way, focusing on the user's needs and the desired outcome.

## Prompt:

can you suggest what tests should be completed on the additional features to fully demonstrate their functionality?

## response:

Sure! Here are the tests that should be completed to fully demonstrate the functionality of the additional features:

### 1. Search Contact by Phone Number
**Test Cases:**
- **Search Existing Contact by Phone Number:**
    - Test if searching by an existing contact's phone number returns the correct contact details.
    - Verify that the contact's name, phone number, and email address are displayed.
- **Search Non-Existing Contact by Phone Number:**
    - Test if searching by a non-existing phone number returns no results.
    - Verify that an appropriate message is displayed indicating no contacts found.

### 2. Search Contact by Email Address
**Test Cases:**
- **Search Existing Contact by Email Address:**
    - Test if searching by an existing contact's email address returns the correct contact details.
    - Verify that the contact's name, phone number, and email address are displayed.
- **Search Non-Existing Contact by Email Address:**
    - Test if searching by a non-existing email address returns no results.
    - Verify that an appropriate message is displayed indicating no contacts found.

### 3. Search Contact by Any Field (Name, Phone Number, or Email Address)
**Test Cases:**
- **Search by Name:**
    - Test if searching by name returns the correct contact details sorted alphabetically.
    - Verify that the contact's name, phone number, and email address are displayed in alphabetical order by name.
- **Search by Phone Number:**
    - Test if searching by phone number returns the correct contact details.
    - Verify that the contact's name, phone number, and email address are displayed.
- **Search by Email Address:**
    - Test if searching by email address returns the correct contact details.
    - Verify that the contact's name, phone number, and email address are displayed.
- **Mixed Field Search:**
    - Test if searching by partial name, phone number, or email address returns the correct matching contacts.
    - Verify that the results are sorted alphabetically by name.

### 4. Delete All Contacts
**Test Cases:**
- **Confirm Delete All Contacts:**
    - Test if confirming the deletion of all contacts actually removes all contacts from the address book.
    - Verify that the address book is empty and an appropriate message is displayed indicating all contacts have been deleted.
- **Cancel Delete All Contacts:**
    - Test if canceling the deletion process leaves the contacts intact.
    - Verify that no contacts are deleted and the address book remains unchanged.
- **Delete All Contacts When Address Book is Empty:**
    - Test the behavior when attempting to delete all contacts from an already empty address book.
    - Verify that an appropriate message is displayed indicating that there are no contacts to delete.

### General Tests for New Features
- **Validation of Unique Phone Number and Email Address:**
    - Test adding a contact with an existing phone number or email address and verify that the application prevents duplication and displays an appropriate error message.
- **Boundary Testing:**
    - Test searching with edge cases such as very long phone numbers, email addresses, and names, or with special characters, to ensure the application handles them correctly.
- **Usability Testing:**
    - Test the user interface for ease of use, ensuring that the search and delete confirmation prompts are clear and intuitive.
- **Performance Testing:**
    - Test the search functionality with a large number of contacts to ensure that the results are returned quickly and the application performs efficiently.

By running these tests, you can ensure that the additional features work as intended and provide a robust, user-friendly experience for managing contacts in the address book.

## prompt:

Thank you.

## Response:

You're welcome! If you have any more questions or need further assistance, feel free to ask. Good luck with your project!
