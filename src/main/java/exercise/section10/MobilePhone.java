package exercise.section10;

import java.util.ArrayList;
import java.util.Optional;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {

        if (findContact(contact.getName()) != -1) {
            return false;
        }
        myContacts.add(contact);

        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {

        if (myContacts.contains(oldContact)) {
            myContacts.remove(oldContact);
            myContacts.add(newContact);

            return true;
        }

        return false;
    }

    public boolean removeContact(Contact contact) {

        if (myContacts.contains(contact)) {
            myContacts.remove(contact);

            return true;
        }

        return false;
    }

    private int findContact(Contact contact) {
        return myContacts.contains(contact) ? myContacts.indexOf(contact) : -1;
    }

    /**
     * udemy compiler 조건에 람다식이 추가됨, 따라서 제출용은 람다식 사용 X
     */
    private int findContact(String name) {
//        Contact contact = myContacts.stream().filter(c -> c.getName().equals(name)).findAny().orElse(null);
//        return (contact != null) ? myContacts.indexOf(contact) : -1;
        for (Contact c : myContacts) {
            if (c.getName().equals(name)) {
                return myContacts.indexOf(c);
            }
        }

        return -1;
    }

    public Contact queryContact(String name) {
        int index = findContact(name);
        return (index != -1) ? myContacts.get(index) : null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact c : myContacts) {
            System.out.printf("%d. %s -> %s%n", myContacts.indexOf(c) + 1, c.getName(), c.getPhoneNumber());
        }
    }
}
