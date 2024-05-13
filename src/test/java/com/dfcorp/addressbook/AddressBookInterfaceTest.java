package com.dfcorp.addressbook;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class AddressBookInterfaceTest {
    private AddressBookInterface testInterface;
    private AddressBook testBook;

    @Nested
    @DisplayName("AddressBook Interface Tests")
    public class InterfaceTests{

        @BeforeEach
        public void setUp(){
            testBook = mock(AddressBook.class);
            testInterface = new AddressBookInterface(testBook);
        }

        @AfterEach
        public void cleanUp(){
            testInterface = null;
        }



        @Test
        @DisplayName("Test to see if DisplayMenu returns the right list")
        public void displayMenuFunctionTest(){
            //Arrange

            //Act

            //Assert
            assertEquals("""
                Welcome to the DF Corp AddressBook
                Please select from the following options:
                     1. (A)dd a contact
                     2. (D)isplay all contacts
                     3. (S)earch for a contact by name
                     4. (E)dit or delete contacts""", testInterface.displayMenu());


        }
    }
}
