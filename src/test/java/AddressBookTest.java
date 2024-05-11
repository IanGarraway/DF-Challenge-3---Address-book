import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressBookTest {
    @Nested
    @DisplayName("AddressBook Class Tests:")
    public class addressBookClassTests {

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
            //AddressBook testBook = new AddressBook();

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
            assertTrue(testBook.numberExists(testNum));
        }
    }
}
