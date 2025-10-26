public class Contact {

    // Unique ID for each contact, cannot be changed once set
    final String contactId;

    // Other contact details
    String firstName;
    String lastName;
    String phone;
    String address;

    // Constructor to create a new Contact
    Contact(String contactId,
            String firstName,
            String lastName,
            String phone,
            String address) {
        // Validate the length and assign values
        this.contactId = validateFieldLength(contactId);
        this.firstName = validateFieldLength(firstName);
        this.lastName = validateFieldLength(lastName);
        this.phone = validatePhoneNumber(phone);
        this.address = validAddressLength(address);
    }
   

    // Helper method to check if phone number is not null and == 10 digits
    private String validatePhoneNumber(String phone) {
        if (phone != null && phone.matches("\\d{1,10}")) {
            return phone;
        } else {
            throw new IllegalArgumentException("Phone number must not be null and must be 10 characters");
        }
    }


    // Helper method to check if a field is not null and <= 10 characters
    private String validateFieldLength(String field) {
        if (field != null && field.length() <= 10) {
            return field;
        } else {
            throw new IllegalArgumentException("Field length must not be null and must be 10 characters or less");
        }
    }

    // Helper method to check if the address is not null and <= 30 characters
    private String validAddressLength(String address) {
        if (address != null && address.length() <= 30) {
            return address;
        } else {
            throw new IllegalArgumentException("Address length must not be null and must be 30 characters or less");
        }
    }

    // ----------------------
    // Getters (read values)
    // ----------------------
    public String getId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // ----------------------
    // Setters (update values)
    // ----------------------
    public void setFirstName(String firstName) {
        this.firstName = validateFieldLength(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = validateFieldLength(lastName);
    }

    public void setPhone(String phone) {
        this.phone = validatePhoneNumber(phone);
    }

    public void setAddress(String address) {
        this.address = validAddressLength(address);
    }
}
