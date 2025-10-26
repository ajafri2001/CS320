import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
    }

    // -------------------------------
    // Constructor Success
    // -------------------------------
    @Test
    void testConstructorSuccess() {
        Contact c = new Contact("456", "Jane", "Smith", "9876543210", "456 Elm St");
        assertEquals("456", c.getId());
        assertEquals("Jane", c.getFirstName());
        assertEquals("Smith", c.getLastName());
        assertEquals("9876543210", c.getPhone());
        assertEquals("456 Elm St", c.getAddress());
    }

    // -------------------------------
    // Constructor Failures
    // -------------------------------
    @Test
    void testConstructorContactIdTooLongFails() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testConstructorFirstNameTooLongFails() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("123", "LongFirstName", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testConstructorLastNameTooLongFails() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("123", "John", "LongLastName", "1234567890", "123 Main St"));
    }

    @Test
    void testConstructorPhoneTooLongFails() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("123", "John", "Doe", "12345678901", "123 Main St"));
    }

    @Test
    void testConstructorPhoneNullFails() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("123", "John", "Doe", null, "123 Main St"));
    }

    @Test
    void testConstructorAddressTooLongFails() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("123", "John", "Doe", "1234567890",
                        "This address is far too long to be considered valid in our contact system"));
    }

    // -------------------------------
    // Setters Success
    // -------------------------------
    @Test
    void testSettersSuccess() {
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("789 Oak Ave");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("789 Oak Ave", contact.getAddress());
    }

    // -------------------------------
    // Setters Failures
    // -------------------------------
    @Test
    void testSetFirstNameTooLongFails() {
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("FirstNameTooLong"));
    }

    @Test
    void testSetLastNameTooLongFails() {
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("LastNameTooLong"));
    }

    @Test
    void testSetPhoneTooLongFails() {
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345678901"));
    }

    @Test
    void testSetPhoneNullFails() {
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
    }

    @Test
    void testSetAddressTooLongFails() {
        assertThrows(IllegalArgumentException.class, () ->
                contact.setAddress("This address is way too long to be valid for any contact record in the system"));
    }

    // -------------------------------
    // Getters
    // -------------------------------
    @Test
    void testGettersReturnExpectedValues() {
        assertEquals("123", contact.getId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }
}
