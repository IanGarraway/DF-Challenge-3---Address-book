import org.junit.jupiter.api.*;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressBookTest {
    @Nested
    @DisplayName("AddressBook Class Tests:")
    public class addressBookClassTests {

        private AddressBook testBook;
        private Contact testContact;

        @BeforeEach
        public void setUp(){
            //try(MockedStatic<StringUtils> mockedStringUtils = Mockito.mockStatic(StringUtils.class)){}
            testBook = new AddressBook();
            testContact = mock(Contact.class);
        }

        @AfterEach
        public void tearDown(){
            testBook = null;
            testContact = null;
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
            testBook.addContact(testContact);

            //Assert
            assertEquals(1, testBook.getContacts().size());
        }

        @Test
        @DisplayName("Multiple contacts can be added to the addressBook")
        public void testOfAddingMultipleContactsToAddressBook(){
            //Arrange
            Contact testContact2 = mock(Contact.class);

            //Act
            testBook.addContact(testContact);
            testBook.addContact(testContact2);

            //Assert
            assertEquals(2, testBook.getContacts().size());
        }

        @Test
        @DisplayName("searchByName feature returns list of contacts whose name matches ")
        public void testOfSearchByName(){
            //Arrange
            Contact testContact2 = mock(Contact.class);
            Contact testContact3 = mock(Contact.class);
            String testName = "Dave Smith";

            when(testContact.getName()).thenReturn("Barry White");
            when(testContact2.getName()).thenReturn(testName);
            when(testContact3.getName()).thenReturn("Barry King");

            //Act
            testBook.addContact(testContact);
            testBook.addContact(testContact2);
            testBook.addContact(testContact3);

            //Assert
            assertEquals(1, testBook.searchByName(testName).size());
        }

        @Test
        @DisplayName("searchByName feature returns list of contacts whose name starts with the request ")
        public void testOfSearchByNameStartingWith(){
            //Arrange
            Contact testContact2 = mock(Contact.class);
            Contact testContact3 = mock(Contact.class);
            String testName = "Barry";

            when(testContact.getName()).thenReturn("Barry White");
            when(testContact2.getName()).thenReturn("Dave Smith");
            when(testContact3.getName()).thenReturn("Barry King");

            //Act
            testBook.addContact(testContact);
            testBook.addContact(testContact2);
            testBook.addContact(testContact3);

            //Assert
            assertEquals(2, testBook.searchByName(testName).size());
        }

        @Test
        @DisplayName("searchByName feature returns list of contacts whose name starts with the request and isn't case-sensitive ")
        public void testOfSearchByNameStartingWithCaseSensitive(){
            //Arrange
            Contact testContact2 = mock(Contact.class);
            Contact testContact3 = mock(Contact.class);
            String testName = "Barry";

            when(testContact.getName()).thenReturn("barry White");
            when(testContact2.getName()).thenReturn("Dave Smith");
            when(testContact3.getName()).thenReturn("Barry King");

            //Act
            testBook.addContact(testContact);
            testBook.addContact(testContact2);
            testBook.addContact(testContact3);

            //Assert
            assertEquals(2, testBook.searchByName(testName).size());
        }
    }
}
