package Lesson_6.Task_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private final Map<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
        fillPhoneBook();
    }

    public List<String> get(String lastName) {
        if (phoneBook.containsKey(lastName)) {
            return phoneBook.get(lastName);
        } else {
            return new ArrayList<>();
        }
    }

    public void add(String lastName, String phone) {
        if (lastName.isEmpty() || phone.isEmpty()) {
            throw new IllegalArgumentException("Empty phone or last name");
        }

        if (phoneBook.containsKey(lastName)) {
            if (phoneBook.get(lastName).contains(phone) == false) {
                phoneBook.get(lastName).add(phone);
            }
        } else {
            List<String> phones = new ArrayList<>();
            phones.add(phone);
            phoneBook.put(lastName, phones);
        }
    }

    private void fillPhoneBook() {
        add("Smith", "123-456-789");
        add("Smith", "321-654-987");
        add("Johnson", "555-111-222");
        add("Williams", "555-333-444");
        add("Brown", "777-888-999");
        add("Jones", "111-222-333");
        add("Miller", "444-555-666");
        add("Davis", "222-333-444");
        add("Garcia", "888-999-000");
        add("Rodriguez", "999-111-222");
        add("Martinez", "333-444-555");
        add("Hernandez", "222-111-000");
        add("Lopez", "555-777-888");
        add("Gonzalez", "111-444-777");
        add("Wilson", "000-123-456");
        add("Anderson", "654-321-000");
        add("Thomas", "222-888-333");
        add("Taylor", "333-111-222");
        add("Moore", "444-111-555");
        add("Jackson", "999-888-777");
        add("Martin", "888-000-111");
        add("Lee", "123-000-999");
        add("Perez", "321-888-123");
        add("Thompson", "000-555-111");
        add("Wilson", "111-000-999");
        add("Anderson", "777-555-333");
        add("Martin", "555-444-123");
    }
}