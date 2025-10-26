import java.util.HashMap;

class ContactService {

    // A HashMap to store contacts using their ID as the key
    HashMap<String, Contact> contactMap = new HashMap<>();

    // Add a new contact to the map
    public void addContact(Contact contact) {
        // Check if a contact with the same ID already exists
        if (contactMap.containsKey(contact.getId())) {
            throw new IllegalArgumentException("Duplicate ID");
        }
        contactMap.put(contact.getId(), contact); // Add contact if ID is unique
    }

    // Remove a contact by its ID
    public void deleteContact(String contactId) {
        contactMap.remove(contactId);
    }

    // Update the first name of a contact by ID
    public void updateFirstName(String contactId, String newFirstName) {
        contactMap.get(contactId).setFirstName(newFirstName);
    }

    // Update the last name of a contact by ID
    public void updateLastName(String contactId, String newLastName) {
        contactMap.get(contactId).setLastName(newLastName);
    }

    // Update the phone number of a contact by ID
    public void updatePhoneNumber(String contactId, String phoneNumber) {
        contactMap.get(contactId).setPhone(phoneNumber);
    }

    // Update the address of a contact by ID
    public void updateAddress(String contactId, String address) {
        contactMap.get(contactId).setAddress(address);
    }
}
