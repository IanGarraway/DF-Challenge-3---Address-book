package com.dfcorp.addressbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest {

    @Nested
    @DisplayName("com.dfcorp.addressbook.Contact Class Tests:")
    public class contactClassTests {

        @Test
        @DisplayName("Object of class can be created and is able to return the starting propertys")
        public void testOfContactClassConstructorAndGetters(){
            //Arrange
            String testName = "John Smith";
            String testNumber = "0113 266 1345";
            String testEmail = "John@Smith.com";

            //Act
            Contact testContact = new Contact(testName, testNumber, testEmail);

            //Assert
            assertAll("Constructor sets values when valid: ",
                    ()-> Assertions.assertEquals(testContact.getName(), testName),
                    ()-> Assertions.assertEquals(testContact.getEmail(), testEmail),
                    ()-> Assertions.assertEquals(testContact.getNumber(), testNumber));
        }

        @Test
        @DisplayName("Confirmation test of setName functioning as intended")
        public void testOfContactClassSetName(){
            //Arrange
            String testName = "John Smith";
            String testNumber = "0113 266 1345";
            String testEmail = "John@Smith.com";
            Contact testContact = new Contact(testName, testNumber, testEmail);

            String newName = "Dave Smith";

            //Act
            testContact.setName(newName);


            //Assert
            Assertions.assertEquals(testContact.getName(), newName);
        }

        @Test
        @DisplayName("Confirmation test of setNumber functioning as intended")
        public void testOfContactClassSetNumber(){
            //Arrange
            String testName = "John Smith";
            String testNumber = "0113 266 1345";
            String testEmail = "John@Smith.com";
            Contact testContact = new Contact(testName, testNumber, testEmail);

            String newNumber = "0113 267 1345";

            //Act
            testContact.setNumber(newNumber);


            //Assert
            Assertions.assertEquals(testContact.getNumber(), newNumber);
        }

        @Test
        @DisplayName("Confirmation test of setEmail functioning as intended")
        public void testOfContactClassSetEmail(){
            //Arrange
            String testName = "Dave Smith";
            String testNumber = "0113 266 1345";
            String testEmail = "John@Smith.com";
            Contact testContact = new Contact(testName, testNumber, testEmail);

            String newEmail = "Dave@Smith.com";

            //Act
            testContact.setEmail(newEmail);


            //Assert
            Assertions.assertEquals(testContact.getEmail(), newEmail);
        }


    }
}
