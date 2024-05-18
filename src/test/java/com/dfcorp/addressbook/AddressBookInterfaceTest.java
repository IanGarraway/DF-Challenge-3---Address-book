package com.dfcorp.addressbook;

import org.junit.jupiter.api.*;


import java.util.ArrayList;
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

        @Nested
        @DisplayName("Output string constructor tests")
        public class OutputStringContructorTests{

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
                testContact1 = null;
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
                         3. (S)earch for a contact by name, phone number or email address
                         4. (M)odify or delete contacts
                         5. (O)rder your contacts
                    
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
                            2. (S)earch by name, phone number or email address
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
        }

        @Nested
        @DisplayName("Tests of the Modification's string input method")
        public class modificationsInputString{
            Scanner in;

            @BeforeEach
            public void setUp(){
                in = new Scanner(System.in);
                testBook = mock(AddressBook.class);
                testInterface = new AddressBookInterface(testBook);
                testContact1 = mock(Contact.class);
            }
            @AfterEach
            public void cleanUP(){
                in = null;
                testBook = null;
                testInterface = null;
                testContact1 = null;
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
                testBook = mock(AddressBook.class);
                testInterface = new AddressBookInterface(testBook);
                testContact1 = mock(Contact.class);

            }

            @AfterEach
            public void cleanUp(){
                mockScanner = null;
                testInterface = null;
                testBook = null;
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
            @DisplayName("Test add contact builds a contact and adds it to the addressbook, with n answered to the first verify question")
            public void testAddContactFunctionsCorrectlyWithANegativeToFirstVerify(){
                //Arrange
                String testName = "Daisy";
                String testNumber = "1234";
                String testEmail = "Daisy@df.com";
                String testVerify1 = "n";
                String testVerify2 = "y";

                testBook = new AddressBook();
                AddressBook spyBook = spy(testBook);

                testInterface = new AddressBookInterface(spyBook);

                when(mockScanner.nextLine()).thenReturn(testName,testNumber,testEmail,testVerify1, testName,testNumber,testEmail,testVerify2);


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

            @Test
            @DisplayName("Test verify contact's input handles capitals")
            public void testOfVerifyContactHandlesCapitals(){
                //Arrange
                String testString1 = "Y";


                when(testContact1.getEmail()).thenReturn("test@test.com");
                when(testContact1.getNumber()).thenReturn("1234");
                when(testContact1.getName()).thenReturn("test");

                when(mockScanner.nextLine()).thenReturn(testString1);

                //Act

                //Assert
                assertTrue(testInterface.verifyContact(testContact1,"is this correct?",mockScanner));
            }

            @Test
            @DisplayName("Test of the getSearchName validation")
            public void testGetSearchNameMethod(){
                //Arrange
                String testName = "Ginny";

                when(mockScanner.nextLine()).thenReturn("", " ",testName);

                //Act

                //Assert
                assertEquals(testName, testInterface.getSearchTerm("something", mockScanner));
            }

            @Test
            @DisplayName("Test modifyContact returns original contact")
            public void testGetModContactBuilder(){


                //Arrange
                String testName = "Ginny";
                String testEmail ="test@test.com";
                String testNumber = "1234";


                when(testContact1.getEmail()).thenReturn(testEmail);
                when(testContact1.getNumber()).thenReturn(testNumber);
                when(testContact1.getName()).thenReturn(testName);

                when(testBook.emailExists(testEmail)).thenReturn(true); //this is a simulated re-enter of the same data on a modification
                when(testBook.numberExists(testNumber)).thenReturn(true); //Contact should exist in the addressbook. should make no difference
                //though as the number and email should match the original.

                when(mockScanner.nextLine()).thenReturn("","","","y" );

                //Act

                Contact builtContact = testInterface.modifyContact(testContact1, mockScanner);

                //Assert
                assertAll("modifyContact's returned contact: ",
                        ()-> Assertions.assertEquals(testName, builtContact.getName()),
                        ()-> Assertions.assertEquals(testEmail, builtContact.getEmail()),
                        ()-> Assertions.assertEquals(testNumber, builtContact.getNumber()));
            }

            @Test
            @DisplayName("Test modifyContact returns original contact, rejecting first userverification")
            public void testGetModContactBuilderWithVerificationRejection(){


                //Arrange
                String testName = "Ginny";
                String testEmail ="test@test.com";
                String testNumber = "1234";


                when(testContact1.getEmail()).thenReturn(testEmail);
                when(testContact1.getNumber()).thenReturn(testNumber);
                when(testContact1.getName()).thenReturn(testName);

                when(testBook.emailExists(testEmail)).thenReturn(true); //this is a simulated re-enter of the same data on a modification
                when(testBook.numberExists(testNumber)).thenReturn(true); //Contact should exist in the addressbook. should make no difference
                //though as the number and email should match the original.

                when(mockScanner.nextLine()).thenReturn("","","","n","","","","y" );

                //Act

                Contact builtContact = testInterface.modifyContact(testContact1, mockScanner);

                //Assert
                assertAll("modifyContact's returned contact: ",
                        ()-> Assertions.assertEquals(testName, builtContact.getName()),
                        ()-> Assertions.assertEquals(testEmail, builtContact.getEmail()),
                        ()-> Assertions.assertEquals(testNumber, builtContact.getNumber()));
            }

            @Test
            @DisplayName("Mod Menu -> Contact Iterator test - moveforward and backwards through the list, delete a contact")
            public void testofContactIterator(){
                //Arrange
                Contact testContact2 = mock(Contact.class);
                Contact testContact3 = mock(Contact.class);

                String testName = "Ginny";
                String testEmail ="test@test.com";
                String testNumber = "1234";

                when(testContact1.getEmail()).thenReturn(testEmail);
                when(testContact1.getNumber()).thenReturn(testNumber);
                when(testContact1.getName()).thenReturn(testName);

                when(testContact2.getEmail()).thenReturn("Mike@John.com");
                when(testContact2.getNumber()).thenReturn("1235");
                when(testContact2.getName()).thenReturn("Mike");
                when(testContact3.getEmail()).thenReturn("jj@Gh.com");
                when(testContact3.getNumber()).thenReturn("1113");
                when(testContact3.getName()).thenReturn("Winston");

                ArrayList<Contact> testList = new ArrayList<>();
                testList.add(testContact1);
                testList.add(testContact2);
                testList.add(testContact3);

                when(testBook.getContacts()).thenReturn(testList);

                // the following mockscanner should imitate a user doing the following:
                // Check two abnormal inputs, select all contacts, two abnormal entries, try to go back through the list, iterate
                //forward through the list till the end, go back one, delete the middle item, then exit of the methods.
                when(mockScanner.nextLine()).thenReturn(""," ", "1","", " ", "p", "n", "N", "n","p","d","n","d","y","e", "e" );

                //Act
                testInterface.modMenu(mockScanner);

                assertEquals(2, testList.size());

            }

            @Test
            @DisplayName("Mod Menu -> Contact Iterator test - moveforward and backwards through the list, delete all contacts")
            public void testofContactIteratorAllDelete(){
                //Arrange
                Contact testContact2 = mock(Contact.class);
                Contact testContact3 = mock(Contact.class);

                String testName = "Ginny";
                String testEmail ="test@test.com";
                String testNumber = "1234";

                when(testContact1.getEmail()).thenReturn(testEmail);
                when(testContact1.getNumber()).thenReturn(testNumber);
                when(testContact1.getName()).thenReturn(testName);

                when(testContact2.getEmail()).thenReturn("Mike@John.com");
                when(testContact2.getNumber()).thenReturn("1235");
                when(testContact2.getName()).thenReturn("Mike");
                when(testContact3.getEmail()).thenReturn("jj@Gh.com");
                when(testContact3.getNumber()).thenReturn("1113");
                when(testContact3.getName()).thenReturn("Winston");

                ArrayList<Contact> testList = new ArrayList<>();
                testList.add(testContact1);
                testList.add(testContact2);
                testList.add(testContact3);

                when(testBook.getContacts()).thenReturn(testList);

                // the following mockscanner should imitate a user doing the following:
                // select all contacts, iterate forward through the list till the end, delete all three then exit of the methods.
                when(mockScanner.nextLine()).thenReturn( "1","n", "N", "n","d","y","d","y","d", "y", "e" );

                //Act
                testInterface.modMenu(mockScanner);

                assertEquals(0, testList.size());

            }

            @Test
            @DisplayName("Mod Menu -> Contact Iterator test - by name, modify contact")
            public void testofContactIteratorModification(){
                //Arrange

                String testName = "Ginny";
                String testEmail ="test@test.com";
                String testNumber = "1234";
                String testReplacementName = "Guinny";

                when(testContact1.getEmail()).thenReturn(testEmail);
                when(testContact1.getNumber()).thenReturn(testNumber);
                when(testContact1.getName()).thenReturn(testName);

                ArrayList<Contact> testList = new ArrayList<>();
                testList.add(testContact1);


                when(testBook.searchByName("Ginny")).thenReturn(testList);

                // the following mockscanner should imitate a user doing the following:
                // Check an abnormal input, select search by name, search for Ginny, modify the name to 'Guinny',
                //accept the original email and phone number, and then exit.
                when(mockScanner.nextLine()).thenReturn( "cat","S", "n", testName, "m", testReplacementName,"","","y","e","e" );

                //Act
                testInterface.modMenu(mockScanner);

                assertEquals(testReplacementName, testList.get(0).getName());

            }

            @Test
            @DisplayName("Start() and Main Menu Test")
            //This test is there to just run through the main loops code and check it handles exceptions correctly.
            public void testofProgramLoopAndMainMenu(){
                //Arrange
                String testName = "Ginny";
                String testEmail ="test@test.com";
                String testNumber = "1234";


                when(testContact1.getEmail()).thenReturn(testEmail);
                when(testContact1.getNumber()).thenReturn(testNumber);
                when(testContact1.getName()).thenReturn(testName);

                ArrayList<Contact> testList = new ArrayList<>();
                testList.add(testContact1);


                when(testBook.getContacts()).thenReturn(testList);
                when(testBook.searchByName("Ginny")).thenReturn(testList);

                // the following mockscanner should imitate a user doing the following:
                // Check some abnormal inputs, select add contact, add Ginny, her number, her email, show all, show search by name, go into the mod menu,
                //come out, enter cat, see the error message press enter, exit the program.
                when(mockScanner.nextLine()).thenReturn( "","  ","A",testName, testNumber, testEmail,"y","2","3", "1",testName,"4", "e","cat", "","e" );

                //Act
                testInterface.start(mockScanner);

                //if the program can go through the code, it's a pass.
                assertTrue(true);


            }



        }

        @Nested
        @DisplayName("Extension Features Tests")
        public class ExtensionFeaturesTests{

            ArrayList<Contact> testList;
            Scanner mockScanner;

            @BeforeEach
            public void setUp(){
                testBook = mock(AddressBook.class);
                testInterface = new AddressBookInterface(testBook);
                testContact1 = mock(Contact.class);
                testList = new ArrayList<>();
                mockScanner = mock(Scanner.class);

            }

            @AfterEach
            public void cleanUp(){
                testInterface = null;
                testBook = null;
                testContact1 = null;
                mockScanner = null;
            }

            @Test
            @DisplayName("Search option menu is returned correctly")
            public void testSearchOptionMenuString(){
                //Arrange

                //Act

                //Assert
                assertEquals("""
                            Search by:
                                1. (N)ame
                                2. (E)mail
                                3. (T)elephone number
                                4. e(X)it
                                :-""", testInterface.displaySearchMenu());
            }

            @Test
            @DisplayName("Search by Telephone number")
            public void testSearchByNumber(){
                //Arrange
                String testSearchNumber = "1234";

                testList.add(testContact1);

                when(testBook.searchByNumber(testSearchNumber)).thenReturn(testList);

                //the following mockscanner will simulate a user: hitting enter, hitting space and then enter, entering the option for
                //telephone number search, hitting enter, before entering a valid number
                when(mockScanner.nextLine()).thenReturn("", " ", "t", "", testSearchNumber);

                //Act
                testList = testInterface.searchChoice(mockScanner);

                //Assert
                assertEquals(1, testList.size());
            }

            @Test
            @DisplayName("Search by Email")
            public void testSearchByEmail(){
                //Arrange
                String testSearchEmail = "test@test.com";

                testList.add(testContact1);

                when(testBook.searchByEmail(testSearchEmail)).thenReturn(testList);

                //the following mockscanner will simulate a user: hitting enter, hitting space and then enter, entering the option for
                //telephone number search, hitting enter, hitting space then enter, before entering a valid email
                when(mockScanner.nextLine()).thenReturn("", " ", "e", "", " ", testSearchEmail);

                //Act
                testList = testInterface.searchChoice(mockScanner);

                //Assert
                assertEquals(1, testList.size());
            }

            @Test
            @DisplayName("Search by Email")
            public void testExitSearch(){
                //Arrange

                //the following mockscanner will simulate a user: hitting enter, hitting space and then enter, entering the option for
                //telephone number search, hitting enter, hitting space then enter, before entering a valid email
                when(mockScanner.nextLine()).thenReturn("", " ", "x");

                //Act
                testList = testInterface.searchChoice(mockScanner);

                //Assert
                assertEquals(0, testList.size());
            }


        }

         
    }
}
