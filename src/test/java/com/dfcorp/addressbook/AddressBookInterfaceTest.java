package com.dfcorp.addressbook;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookInterfaceTest {
    AddressBookInterface testInterface;

    @Nested
    @DisplayName("AddressBook Interface Tests")
    public class InterfaceTests{

        @BeforeEach
        public void setUp(){
            testInterface = new AddressBookInterface();
        }

        @AfterEach
        public void cleanUp(){
            testInterface = null;
        }

        @Test
        @DisplayName("Test of string validation method")
        public void stringValidationTest(){
            //Arrange
            String testWord = "word";

            //Act

            //Assert
            assertEquals(testWord, testInterface.stringVerify(testWord));
        }

        @Test
        @DisplayName("Test of string validation method - empty")
        public void stringEmptyValidationTest(){
            //Arrange
            String testWord = "";

            //Act

            //Assert
            assertThrows(IllegalArgumentException.class, ()->testInterface.stringVerify(testWord));
        }

        @Test
        @DisplayName("Test of string validation method-just spaces")
        public void stringSpacesValidationTest(){
            //Arrange
            String testWord = "   ";

            //Act

            //Assert
            assertThrows(IllegalArgumentException.class, ()->testInterface.stringVerify(testWord));
        }
    }
}
