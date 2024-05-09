import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest {

    @Nested
    @DisplayName("Contact Class Tests:")
    public class contactClassTests {

        @Test
        @DisplayName("Object of class can be created and is able to return the starting propertys")
        public void testOfContactClassConstructorAndGetters(){
            //Arrange
            String testName = "John Smith";
            String testNumber = "0113 266 1345";
            String testEmail = "John@Smith.com";

            //Act
            Contact testContact = new Contact(testName, testNumber, testEmail);

            //Assert
            assertAll("Constructor sets values when valid: ",
                    ()->assertEquals(testContact.getName(), testName),
                    ()->assertEquals(testContact.getEmail(), testEmail),
                    ()->assertEquals(testContact.getNumber(), testNumber));
        }


    }
}
