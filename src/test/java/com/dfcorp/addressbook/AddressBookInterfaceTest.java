package com.dfcorp.addressbook;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;


import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
                     4. (M)odify or delete contacts
                     
                     or e to exit.
                :-""", testInterface.displayMenu());
        }

        @Test
        @DisplayName("Test to see if modify choices returns correctly")
        public void modifyContactsChoiceOptionsDisplayCorrectlyTest(){
            //Arraange
            //Act
            //Assert
            assertEquals("""
                    AddressBook Contact Review
                    Do you wish to see :
                        1. (A)ll contacts
                        2. (S)earch by name
                        3. (E)xit to the main menu
                    """,testInterface.displayModMenu());
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

        @Test
        @DisplayName("Edit choices are displayed correctly, one contact")
        public void editChoicesDisplayTest(){
            //Arrange
            //Act
            //Assert
            assertEquals("<(e)xit, (d)elete, (m)odify>", testInterface.modChoices(0,1));
        }

        @Test
        @DisplayName("Edit choices are displayed correctly, one contact")
        public void editChoicesDisplayTestStartOfMultipleList(){
            //Arrange
            //Act
            //Assert
            assertEquals("<(e)xit, (d)elete, (m)odify, (n)ext>", testInterface.modChoices(0,5));
        }

        @Test
        @DisplayName("Edit choices are displayed correctly, mid contact")
        public void editChoicesDisplayTestMidOfMultipleList(){
            //Arrange
            //Act
            //Assert
            assertEquals("<(p)revious,(e)xit, (d)elete, (m)odify, (n)ext>", testInterface.modChoices(2,5));
        }

        @Test
        @DisplayName("Edit choices are displayed correctly, end contact")
        public void editChoicesDisplayTestEndOfMultipleList(){
            //Arrange
            //Act
            //Assert
            assertEquals("<(p)revious,(e)xit, (d)elete, (m)odify>", testInterface.modChoices(4,5));
        }

        @Nested
        @DisplayName("Tests of the Modification's string input method")
        public class modificationsInputString{
            Scanner in;

            @BeforeEach
            public void setUp(){
                in = new Scanner(System.in);
            }
            @AfterEach
            public void cleanUP(){
                in = null;
            }


            @Test
            @DisplayName("Modify Contact String with option to use previous string method - empty user input")
            public void stringBlankReturnsOriginalStringTest(){
                //Arrange

                //Act
                //Assert
                assertEquals("Test", testInterface.modString("","Test", in));


            }
            @Test
            @DisplayName("Modify Contact String with option to use previous string method - different user input")
            public void stringUserChangeStringTest(){
                //Arrange
                String testString = "Test";
                String originalString = "Dave";

                //Act
                //Assert
                assertEquals(testString, testInterface.modString(testString,originalString, in));


            }

        }


        @Nested
        @DisplayName("Input tests")
        public class InputTests{
            Scanner mockScanner;
            @BeforeEach
            public void setUp(){
                mockScanner = mock(Scanner.class);

            }

            @AfterEach
            public void cleanUp(){
                mockScanner = null;
            }

            @Test
            @DisplayName("Test of newName method")
            public void testNewNameMethod(){
                //Arrange
                String testWord = "Test";
                when(mockScanner.nextLine()).thenReturn(testWord);

                //Act

                //Assert
                assertEquals(testWord, testInterface.newName(mockScanner));

            }

            @Test
            @DisplayName("Test of newName method")
            public void testNewNameMethodFailFirst(){
                //Arrange
                String testWord = "Test";

                when(mockScanner.nextLine()).thenReturn("  ", "", testWord);

                //Act
                //Assert
                assertEquals(testWord, testInterface.newName(mockScanner));

            }

            @Test
            @DisplayName("Test of newNumber method normal entry")
            public void testNewNumberMethodWorks(){
                //Arrange
                String testNumber = "1234";
                when(mockScanner.nextLine()).thenReturn(testNumber);
                when(testBook.numberExists(any())).thenReturn(false);

                //Act

                //Assert
                assertEquals(testNumber, testInterface.newNumber(mockScanner));
            }

            @Test
            @DisplayName("Test of newName method")
            public void testNewNumberMethodFailFirst(){
                //Arrange
                String testNumber = "1234";

                when(mockScanner.nextLine()).thenReturn("  ", "", testNumber);
                when(testBook.numberExists(any())).thenReturn(false);

                //Act
                //Assert
                assertEquals(testNumber, testInterface.newNumber(mockScanner));

            }

            @Test
            @DisplayName("Test of newName method")
            public void testNewNumberMethodExistingNumberFailFirst(){
                //Arrange
                String testNumber = "1234";
                String badNumber = "1235";

                when(mockScanner.nextLine()).thenReturn(badNumber, testNumber);
                when(testBook.numberExists(badNumber)).thenReturn(true);
                when(testBook.numberExists(testNumber)).thenReturn(false);

                //Act
                //Assert
                assertEquals(testNumber, testInterface.newNumber(mockScanner));

            }

            @Test
            @DisplayName("Test of the newEmail method")
            public void testNewEmailMethodFunctions(){
                //Arrange
                String testWord = "Test@Test.com";
                when(mockScanner.nextLine()).thenReturn(testWord);

                //Act

                //Assert
                assertEquals(testWord, testInterface.newEmail(mockScanner));
            }

            @Test
            @DisplayName("Test newEmail method, will loop until a valid email is entered")
            public void testNewEmailMethodVerificationFunctions(){
                //Arrange
                String testEmail = "Test@Test.com";
                String badEmail = "Test";
                String badEmail2 = "Test@";
                String badEmail3 = "Test@test";
                when(mockScanner.nextLine()).thenReturn(badEmail, badEmail2, badEmail3, testEmail);

                //Act

                //Assert
                assertEquals(testEmail, testInterface.newEmail(mockScanner));
            }

            @Test
            @DisplayName("Test newEmail method, will loop until an email testbook says is unique is entered")
            public void testNewEmailExistsVerificationFunctions(){
                //Arrange
                String testEmail = "Test@Test.com";
                String badEmail = "Testing@Test.com";

                when(mockScanner.nextLine()).thenReturn(badEmail, testEmail);
                when(testBook.emailExists(badEmail)).thenReturn(true);
                when(testBook.emailExists(testEmail)).thenReturn(false);

                //Act

                //Assert
                assertEquals(testEmail, testInterface.newEmail(mockScanner));
            }

            @Test
            @DisplayName("uniqueModNumber doesn't accept an already existing number")
            public void testUniqueModNumberCorrectlyHandlesAlreadyExistingNumbers(){
                //Arrange
                String testNumber = "1234";
                String badNumber = "1235";
                String testOriginalNumber = "1233";

                when(mockScanner.nextLine()).thenReturn(badNumber, testNumber);
                when(testBook.numberExists(badNumber)).thenReturn(true);
                when(testBook.numberExists(testNumber)).thenReturn(false);

                //Act

                //Assert
                assertEquals(testNumber, testInterface.uniqueModNumber(testOriginalNumber, mockScanner));

            }

            @Test
            @DisplayName("uniqueModNumber doesn't accept an already existing number, unless it is the original")
            public void testUniqueModNumberAcceptsTheOriginalNumber(){
                //Arrange
                String testNumber = "1234";
                String badNumber = "1235";


                when(mockScanner.nextLine()).thenReturn(badNumber, testNumber);
                when(testBook.numberExists(badNumber)).thenReturn(true);
                when(testBook.numberExists(testNumber)).thenReturn(true);

                //Act

                //Assert
                assertEquals(testNumber, testInterface.uniqueModNumber(testNumber, mockScanner));

            }

            @Test
            @DisplayName("Test to ensure uniqueModEmail blocks existing emails")
            public void testOfUniqueModEmailDoesNotAcceptExistingEmails(){
                //Arrange
                String originalEmail = "very@old.com";
                String testEmail = "Test@Test.com";
                String badEmail = "Testy@Test.com";

                when(mockScanner.nextLine()).thenReturn(badEmail,testEmail);
                when(testBook.emailExists(badEmail)).thenReturn(true);
                when(testBook.emailExists(testEmail)).thenReturn(false);

                //Act
                //Assert
                assertEquals(testEmail, testInterface.uniqueModEmail(originalEmail, mockScanner));
            }

            @Test
            @DisplayName("Test to ensure uniqueModEmail blocks existing emails")
            public void testOfUniqueModEmailDoesNotAcceptExistingEmailsUnlessItsTheOriginal(){
                //Arrange

                String testEmail = "Test@Test.com";
                String badEmail = "Testy@Test.com";

                when(mockScanner.nextLine()).thenReturn(badEmail,testEmail);
                when(testBook.emailExists(badEmail)).thenReturn(true);
                when(testBook.emailExists(testEmail)).thenReturn(false);

                //Act
                //Assert
                assertEquals(testEmail, testInterface.uniqueModEmail(testEmail, mockScanner));
            }

            @Test
            @DisplayName("Test add contact builds a contact and adds it to the addressbook")
            public void testAddContactFunctionsCorrectly(){
                //Arrange
                String testName = "Daisy";
                String testNumber = "1234";
                String testEmail = "Daisy@df.com";
                String testVerify = "y";

                testBook = new AddressBook();
                AddressBook spyBook = spy(testBook);

                testInterface = new AddressBookInterface(spyBook);

                when(mockScanner.nextLine()).thenReturn(testName,testNumber,testEmail,testVerify);


                //Act
                testInterface.addContact(mockScanner);

                //Verify

                assertEquals(1, spyBook.getContacts().size());

            }

            @Test
            @DisplayName("Test verify contact's input handles bad input's correctly before outputting false on a negative")
            public void testOfVerifyContactBadInputHandlingAndNegativeInputResponse(){
                //Arrange
                String testString1 = "";
                String testString2 = "  ";
                String testString3 = "nah";
                String testString4 = "n";

                when(testContact1.getEmail()).thenReturn("test@test.com");
                when(testContact1.getNumber()).thenReturn("1234");
                when(testContact1.getName()).thenReturn("test");

                when(mockScanner.nextLine()).thenReturn(testString1,testString2,testString3,testString4);

                //Act

                //Assert
                assertFalse(testInterface.verifyContact(testContact1,"is this correct?",mockScanner));
            }



        }

         
    }
}
