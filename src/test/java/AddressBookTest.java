import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookTest {
    @Nested
    @DisplayName("AddressBook Class Tests:")
    public class addressBookClassTests {

        @Test
        @DisplayName("AddressBook can be instantiated and return an empty list")
        public void testOfAddressBookInstantiationAndAllContactReturn(){
            //Arrange

            //Act
            AddressBook testBook = new AddressBook();

            //Assert
            assertEquals(testBook.getContacts().size(), 0);
        }
    }
}
