package com.dfcorp.addressbook;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;


import java.util.Scanner;

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
        }

         
    }
}
