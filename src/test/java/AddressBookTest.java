import org.junit.jupiter.api.*;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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
    }
}
