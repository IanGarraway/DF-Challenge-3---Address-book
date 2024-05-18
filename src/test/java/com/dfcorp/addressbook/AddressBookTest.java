package com.dfcorp.addressbook;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressBookTest {
    @Nested
    @DisplayName("AddressBook Class Core function Tests:")
    public class addressBookClassCoreFunctionTests {

        private AddressBook testBook;
        private Contact testContact1, testContact2, testContact3;

        @BeforeEach
        public void setUp(){
            //try(MockedStatic<StringUtils> mockedStringUtils = Mockito.mockStatic(StringUtils.class)){}
            testBook = new AddressBook();
            testContact1 = mock(Contact.class);
            testContact2 = mock(Contact.class);
            testContact3 = mock(Contact.class);
        }

        @AfterEach
        public void tearDown(){
            testBook = null;
            testContact1 = null;
            testContact2 = null;
            testContact3 = null;
        }

        @Test
        @DisplayName("AddressBook can be instantiated and return an empty list")
        public void testOfAddressBookInstantiationAndAllContactReturn(){
            //Arrange

            //Act


            //Assert
            assertEquals(testBook.getContacts().size(), 0);
        }

        @Test
        @DisplayName("A contact can be added to the addressBook")
        public void testOfAddContactToAddressBook(){
            //Arrange

            //Act
            testBook.addContact(testContact1);

            //Assert
            assertEquals(1, testBook.getContacts().size());
        }

        @Test
        @DisplayName("Multiple contacts can be added to the addressBook")
        public void testOfAddingMultipleContactsToAddressBook(){
            //Arrange


            //Act
            testBook.addContact(testContact1);
            testBook.addContact(testContact2);

            //Assert
            assertEquals(2, testBook.getContacts().size());
        }

        @Test
        @DisplayName("searchByName feature returns list of contacts whose name matches ")
        public void testOfSearchByName(){
            //Arrange
            String testName = "Dave Smith";

            when(testContact1.getName()).thenReturn("Barry White");
            when(testContact2.getName()).thenReturn(testName);
            when(testContact3.getName()).thenReturn("Barry King");

            //Act
            testBook.addContact(testContact1);
            testBook.addContact(testContact2);
            testBook.addContact(testContact3);

            //Assert
            assertEquals(1, testBook.searchByName(testName).size());
        }

        @Test
        @DisplayName("searchByName feature returns list of contacts whose name starts with the request ")
        public void testOfSearchByNameStartingWith(){
            //Arrange
            String testName = "Barry";

            when(testContact1.getName()).thenReturn("Barry White");
            when(testContact2.getName()).thenReturn("Dave Smith");
            when(testContact3.getName()).thenReturn("Barry King");

            //Act
            testBook.addContact(testContact1);
            testBook.addContact(testContact2);
            testBook.addContact(testContact3);

            //Assert
            assertEquals(2, testBook.searchByName(testName).size());
        }

        @Test
        @DisplayName("searchByName feature returns list of contacts whose name starts with the request and isn't case-sensitive ")
        public void testOfSearchByNameStartingWithCaseSensitive(){
            //Arrange
            String testName = "Barry";

            when(testContact1.getName()).thenReturn("barry White");
            when(testContact2.getName()).thenReturn("Dave Smith");
            when(testContact3.getName()).thenReturn("Barry King");

            //Act
            testBook.addContact(testContact1);
            testBook.addContact(testContact2);
            testBook.addContact(testContact3);

            //Assert
            assertEquals(2, testBook.searchByName(testName).size());
        }

        @Test
        @DisplayName("remove contact feature removes the contact ")
        public void testOfRemoveContact(){
            //Arrange
            testBook.addContact(testContact1);
            testBook.addContact(testContact2);
            testBook.addContact(testContact3);

            //Act
            testBook.removeContact(testContact2);

            //Assert
            assertEquals(2, testBook.getContacts().size());
        }

        @Test
        @DisplayName("replaceContact will replace an existing contact with a new one")
        public void testOfReplaceContact(){
            //Arrange
            String testName = "Emma";
            when(testContact1.getName()).thenReturn("Dave");
            when(testContact2.getName()).thenReturn(testName);
            testBook.addContact(testContact1);

            //Act
            testBook.replaceContact(testContact1, testContact2);

            //Assert
            assertEquals(testBook.getContacts().get(0).getName(), testName);

        }

        @Test
        @DisplayName("determines if a number exists in the addressbook")
        public void numberExistsTest(){
            //Arrange
            String testNum = "01234";
            when(testContact1.getNumber()).thenReturn(testNum);
            when(testContact2.getNumber()).thenReturn("01235");
            testBook.addContact(testContact1);
            testBook.addContact(testContact2);

            //Act

            //Assert
            Assertions.assertTrue(testBook.numberExists(testNum));
        }

        @Test
        @DisplayName("determines if a number exists in the addressbook")
        public void numberDoesntExistTest(){
            //Arrange
            String testNum = "01234";
            when(testContact1.getNumber()).thenReturn("01235");
            when(testContact2.getNumber()).thenReturn("01236");
            testBook.addContact(testContact1);
            testBook.addContact(testContact2);

            //Act

            //Assert
            Assertions.assertFalse(testBook.numberExists(testNum));
        }
        @Test
        @DisplayName("determines if a email address exists in the addressbook")
        public void emailExistsTest(){
            //Arrange
            String testEmail = "a@b.com";
            when(testContact1.getEmail()).thenReturn(testEmail);
            when(testContact2.getEmail()).thenReturn("b@b.com");
            testBook.addContact(testContact1);
            testBook.addContact(testContact2);

            //Act

            //Assert
            Assertions.assertTrue(testBook.emailExists(testEmail));
        }
        @Test
        @DisplayName("determines if a email address doesnt exist in the addressbook")
        public void emaildoesntExistTest(){
            //Arrange
            String testEmail = "a@b.com";
            when(testContact1.getEmail()).thenReturn("c@b.com");
            when(testContact2.getEmail()).thenReturn("b@b.com");
            testBook.addContact(testContact1);
            testBook.addContact(testContact2);

            //Act

            //Assert
            Assertions.assertFalse(testBook.emailExists(testEmail));
        }

    }
    @Nested
    @DisplayName("AddressBook Class Additional function Tests:")
    public class addressBookClassAdditionalFunctionTests {
        private AddressBook testBook;
        private Contact testContact1, testContact2, testContact3;

        @BeforeEach
        public void setUp(){
            //try(MockedStatic<StringUtils> mockedStringUtils = Mockito.mockStatic(StringUtils.class)){}
            testBook = new AddressBook();
            testContact1 = mock(Contact.class);
            testContact2 = mock(Contact.class);
            testContact3 = mock(Contact.class);
        }

        @AfterEach
        public void tearDown(){
            testBook = null;
            testContact1 = null;
            testContact2 = null;
            testContact3 = null;
        }

        @Test
        @DisplayName("test confirming searchByNumber will return a list containing a contact whose number matches")
        public void testOfSearchByNumberBasicFunction(){
            //Arrange
            String testNumber = "1234";
            String badNumber1 = "1111";
            String badNumber2 = "2222";

            when(testContact1.getNumber()).thenReturn(badNumber2);
            when(testContact2.getNumber()).thenReturn(badNumber1);
            when(testContact3.getNumber()).thenReturn(testNumber);

            testBook.addContact(testContact1);
            testBook.addContact(testContact2);
            testBook.addContact(testContact3);

            assertEquals(testNumber,testBook.searchByNumber(testNumber).get(0).getNumber());

        }

    }
}
