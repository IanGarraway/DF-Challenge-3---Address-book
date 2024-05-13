package com.dfcorp.addressbook;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VerifyerTest {
    //Verifyer testVerifyer;

    @Nested
    @DisplayName("Verification Tests")
    public class VerificationTests{

        @Nested
        @DisplayName("String Verification")
        public class StringVerificationTests {


            @Test
            @DisplayName("Test of string validation method")
            public void stringValidationTest() {
                //Arrange
                String testWord = "word";

                //Act

                //Assert
                assertEquals(testWord, Verifyer.string(testWord));
            }

            @Test
            @DisplayName("Test of string validation method - empty")
            public void stringEmptyValidationTest() {
                //Arrange
                String testWord = "";

                //Act

                //Assert
                assertThrows(IllegalArgumentException.class, () -> Verifyer.string(testWord));
            }

            @Test
            @DisplayName("Test of string validation method-just spaces")
            public void stringSpacesValidationTest() {
                //Arrange
                String testWord = "   ";

                //Act

                //Assert
                assertThrows(IllegalArgumentException.class, () -> Verifyer.string(testWord));
            }
        }

        @Nested
        @DisplayName("Email verification tests")
        public class emailVerificationTests{


            @Test
            @DisplayName("Invalid email format check")
            public void invalidEmailFormatingCheck(){
                //Arrange
                String testEmail = "bob@";

                //Act

                //Assert
                assertThrows(IllegalArgumentException.class, ()->Verifyer.email(testEmail));

            }

            @Test
            @DisplayName("Valid email format check")
            public void validEmailFormatingCheck(){
                //Arrange
                String testEmail = "Bob@company.com";

                //Act

                //Assert
                assertEquals(testEmail, Verifyer.email(testEmail));

            }

            @Test
            @DisplayName("Valid email format check different format")
            public void validEmail2FormatingCheck(){
                //Arrange
                String testEmail = "Bob.Smith@company.co.uk";

                //Act

                //Assert
                assertEquals(testEmail, Verifyer.email(testEmail));

            }
            @Test
            @DisplayName("Blank string input email format check")
            public void blankStringInvalidFormatingCheck(){
                //Arrange
                String testEmail = "";

                //Act

                //Assert
                assertThrows(IllegalArgumentException.class, ()->Verifyer.email(testEmail));

            }
        }

    }

}
