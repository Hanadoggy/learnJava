package section15_collections;

import section15_collections.challenge_set.Contact;
import section15_collections.challenge_set.ContactData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("----------------------");

        Map<String, Contact> contacts = new HashMap<>();
        for (Contact contact : fullList) {
            contacts.put(contact.getName(), contact);
        }
        contacts.forEach((k, v) -> System.out.println("KEY = " + k + " VALUE = " + v));

        System.out.println("----------------------");
        System.out.println(contacts.get("Charlie Brown"));
        // get은 해당 키가 없으면 null 반환
        System.out.println(contacts.get("Chuck Brown"));
        System.out.println(contacts.getOrDefault("Chuck Brown", new Contact("Chuck Brown")));
        // getOrDefault는 만약 키가 없으면 기본값으로 설정한 객체를 반환

        System.out.println("-----------------------");
        contacts.clear();
        for (Contact contact : fullList) {
            Contact duplicate = contacts.put(contact.getName(), contact);
            if (duplicate != null) {
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k, v) -> System.out.println("KEY = " + k + " VALUE = " + v));

        System.out.println("--------------------------");
        contacts.clear();
        for (Contact contact : fullList) {
            contacts.putIfAbsent(contact.getName(), contact);
        }
        contacts.forEach((k, v) -> System.out.println("KEY = " + k + " VALUE = " + v));

        System.out.println("--------------------------");
        contacts.clear();
        for (Contact contact : fullList) {
            Contact duplicate = contacts.putIfAbsent(contact.getName(), contact);
            if (duplicate != null) {
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k, v) -> System.out.println("KEY = " + k + " VALUE = " + v));

        System.out.println("------------------------");
        contacts.clear();
        fullList.forEach(contact -> contacts.merge(contact.getName(), contact,
                Contact::mergeContactData));
        contacts.forEach((k, v) -> System.out.println("KEY = " + k + " VALUE = " + v));

        System.out.println("-------------------------");
        for (String contactName : new String[]{"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}) {
            contacts.compute(contactName, (k, v) -> new Contact(k));
            // 키의 유무에 상관없이 실행

            contacts.computeIfAbsent(contactName, Contact::new);
            // 키가 없을때만 실행

            contacts.computeIfPresent(contactName, (k, v) -> {
                v.addEmail("Fun Place"); return v; });
            // 키가 있을때만 실행
        }
        contacts.forEach((k, v) -> System.out.println("KEY = " + k + " VALUE = " + v));

        System.out.println("-------------------------------");
        contacts.replaceAll((k, v) -> {
            String newEmail = k.replaceAll(" ", "") + "@funplace.com";
            v.replaceEmailIfExists("DDuck@funplace.com", newEmail);
            return v;
        });
        contacts.forEach((k, v) -> System.out.println("KEY = " + k + ", VALUE = " + v));

        System.out.println("------------------------------");
        Contact daisy = new Contact("Daisy Jane Duck", "daisyj@duck.com");

        Contact replacedContact = contacts.replace("Daisy Duck", daisy);
        System.out.println("daisy = " + daisy);
        System.out.println("replacedContact = " + replacedContact);
        contacts.forEach((k, v) -> System.out.println("KEY = " + k + " VALUE = " + v));

        System.out.println("--------------------");
        Contact updatedDaisy = replacedContact.mergeContactData(daisy);
        System.out.println("updatedDaisy = " + updatedDaisy);
        System.out.printf(contacts.replace("Daisy Duck", daisy, updatedDaisy) ?
                "Successfully replaced element%n" :
                "Did not match on both key: %s and value: %s %n", "Daisy Duck", daisy);
        //
        contacts.forEach((k, v) -> System.out.println("KEY = " + k + " VALUE = " + v));

        System.out.println("--------------------");
        System.out.printf(contacts.remove("Daisy Duck", daisy) ?
                "Successfully removed element%n" :
                "Did not match on both key: %s and value: %s %n", "Daisy Duck", daisy);
        contacts.forEach((k, v) -> System.out.println("KEY = " + k + " VALUE = " + v));

    }

}
