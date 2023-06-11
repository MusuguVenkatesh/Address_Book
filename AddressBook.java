package jdbc_first;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    private Map<String, String> contacts;

    public AddressBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        contacts.put(name, phoneNumber);
        System.out.println("Contact added successfully.");
    }

    public void searchContact(String name) {
        if (contacts.containsKey(name)) {
            String phoneNumber = contacts.get(name);
            System.out.println("Name: " + name + ", Phone Number: " + phoneNumber);
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Address book is empty.");
        } else {
            System.out.println("Address Book:");
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                String name = entry.getKey();
                String phoneNumber = entry.getValue();
                System.out.println("Name: " + name + ", Phone Number: " + phoneNumber);
            }
        }
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Display All Contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    addressBook.addContact(name, phoneNumber);
                    break;
                case 2:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    addressBook.searchContact(searchName);
                    break;
                case 3:
                    addressBook.displayAllContacts();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            
        }
    }
}

