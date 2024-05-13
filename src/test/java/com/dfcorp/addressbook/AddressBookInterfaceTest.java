package com.dfcorp.addressbook;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressBookInterfaceTest {
    private AddressBookInterface testInterface;
    private AddressBook testBook;
    private Contact testContact1;

    @Nested
    @DisplayName("AddressBook Interface Tests")
    public class InterfaceTests{

        @BeforeEach
        public void setUp(){
            testBook = mock(AddressBook.class);
            testInterface = new AddressBookInterface(testBook);
            testContact1 = mock(Contact.class);
        }

        @AfterEach
        public void cleanUp(){
            testInterface = null;
            testBook = null;
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

        @Test
        @DisplayName("Test to see if the contact string display builder, outputs the right string")
        public void contactStringBuilderFunctionTest(){
            //Arrange
            when(testContact1.getName()).thenReturn("Sara");
            when(testContact1.getNumber()).thenReturn("12345");
            when(testContact1.getEmail()).thenReturn("Sara@test.com");
            //Act
            //Assert
            assertEquals("""
                    Name: Sara
                    Phone: 12345
                    Email: Sara@test.com
                    """, testInterface.displayContactStringBuilder(testContact1).toString());


        }
    }
}
