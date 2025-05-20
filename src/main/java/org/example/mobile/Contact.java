package org.example.mobile;

public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Contact)) return false;

        Contact contact = (Contact) obj;
        return this.name.equals(contact.getName()) &&
                this.phoneNumber.equals(contact.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return name.hashCode() + phoneNumber.hashCode();
    }


}
