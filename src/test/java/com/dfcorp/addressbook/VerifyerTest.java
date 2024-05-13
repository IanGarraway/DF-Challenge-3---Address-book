package com.dfcorp.addressbook;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VerifyerTest {
    //Verifyer testVerifyer;

    @Nested
    @DisplayName("Verification Tests")
    public class VerificationTests{


        @Test
        @DisplayName("Test of string validation method")
        public void stringValidationTest(){
            //Arrange
            String testWord = "word";

            //Act

            //Assert
            assertEquals(testWord, Verifyer.string(testWord));
        }

        @Test
        @DisplayName("Test of string validation method - empty")
        public void stringEmptyValidationTest(){
            //Arrange
            String testWord = "";

            //Act

            //Assert
            assertThrows(IllegalArgumentException.class, ()->Verifyer.string(testWord));
        }

        @Test
        @DisplayName("Test of string validation method-just spaces")
        public void stringSpacesValidationTest(){
            //Arrange
            String testWord = "   ";

            //Act

            //Assert
            assertThrows(IllegalArgumentException.class, ()->Verifyer.string(testWord));
        }
    }

}
