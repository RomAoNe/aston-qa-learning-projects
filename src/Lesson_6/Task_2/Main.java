package Lesson_6.Task_2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PhoneBook contacts = new PhoneBook();

        addPhone(contacts, "Martin", "312-123-412");
        findPhones(contacts, "Martin");
    }

    public static void findPhones(PhoneBook phoneBook, String lastName) {
        List<String> phones = phoneBook.get(lastName);

        if (phones.isEmpty()) {
            System.out.println("No entries found for last name: " + lastName);
        } else {
            System.out.println("The following phone numbers were found for " + lastName + ":");
            for (String phone : phones) {
                System.out.println(" - " + phone);
            }
        }
    }

    public static void addPhone(PhoneBook phoneBook, String lastName, String phone) {
        try {
            phoneBook.add(lastName, phone);
        } catch (IllegalArgumentException exception) {
            System.out.println("Wrong input: " + exception.getMessage());
        }
    }
}