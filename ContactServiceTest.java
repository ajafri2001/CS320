import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact = new Contact("123", "John", "Doe", "5551234", "123 Main St");
    }

    // -------------------------------
    // Add / Delete Tests
    // -------------------------------

    @Test
    @Tag("addDelete")
    void testAddContactSuccess() {
        service.addContact(contact);
        assertEquals(contact, service.contactMap.get("123"));
    }

    @Test
    @Tag("addDelete")
    void testAddDuplicateContactIdFails() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    @Test
    @Tag("addDelete")
    void testDeleteContactSuccess() {
        service.addContact(contact);
        service.deleteContact("123");
        assertNull(service.contactMap.get("123"));
    }

    // -------------------------------
    // Update Tests - Success Cases
    // -------------------------------

    @Test
    @Tag("update")
    void testUpdateFirstNameSuccess() {
        service.addContact(contact);
        service.updateFirstName("123", "Jane");
        assertEquals("Jane", service.contactMap.get("123").getFirstName());
    }

    @Test
    @Tag("update")
    void testUpdateLastNameSuccess() {
        service.addContact(contact);
        service.updateLastName("123", "Smith");
        assertEquals("Smith", service.contactMap.get("123").getLastName());
    }

    @Test
    @Tag("update")
    void testUpdatePhoneSuccess() {
        service.addContact(contact);
        service.updatePhoneNumber("123", "9876543");
        assertEquals("9876543", service.contactMap.get("123").getPhone());
    }

    @Test
    @Tag("update")
    void testUpdateAddressSuccess() {
        service.addContact(contact);
        service.updateAddress("123", "456 Elm St");
        assertEquals("456 Elm St", service.contactMap.get("123").getAddress());
    }

    // -------------------------------
    // Update Tests - Failure Cases
    // -------------------------------

    @Test
    @Tag("update")
    void testUpdateFirstNameTooLongFails() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("123", "NameTooLongHere"));
    }

    @Test
    @Tag("update")
    void testUpdateLastNameTooLongFails() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("123", "LastNameTooLong"));
    }

    @Test
    @Tag("update")
    void testUpdatePhoneTooLongFails() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber("123", "12345678901"));
    }

    @Test
    @Tag("update")
    void testUpdateAddressTooLongFails() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class,
                () -> service.updateAddress("123", "This address is way too long to be valid in our system"));
    }

    // -------------------------------
    // Null Safety Tests
    // -------------------------------

    @Test
    @Tag("nullSafety")
    void testUpdateNonExistingContactFails() {
        assertThrows(NullPointerException.class, () -> service.updateFirstName("999", "Test"));
        assertThrows(NullPointerException.class, () -> service.updateLastName("999", "Test"));
        assertThrows(NullPointerException.class, () -> service.updatePhoneNumber("999", "1234"));
        assertThrows(NullPointerException.class, () -> service.updateAddress("999", "Test Address"));
    }
}
