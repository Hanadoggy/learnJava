package section15_collections.challenge_set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contact {

    private String name;
    private Set<String> emails = new HashSet<>();
    private Set<String> phones = new HashSet<>();

    public Contact(String name) {
        this(name, null, null);
    }

    public Contact(String name, String email) {
        this(name, email, null);
    }

    public Contact(String name, long phone) {
        this(name, null, phone);
    }

    public Contact(String name, String email, Long phone) {
        this.name = name;
        if (email != null) {
            this.emails.add(email);
        }
        if (phone != null) {
            String s = Long.toString(phone);
            this.phones.add("(%s) %s-%s".formatted(
                    s.substring(0,3 ), s.substring(3, 6), s.substring(6)
            ));
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%s: %s %s".formatted(name, emails, phones);
    }

    public Contact getData(Contact contact) {

        Contact newContact = new Contact(name);
        newContact.emails = new HashSet<>(this.emails);
        newContact.phones = new HashSet<>(this.phones);
        newContact.emails.addAll(contact.emails);
        newContact.phones.addAll(contact.phones);

        return newContact;
    }
}
