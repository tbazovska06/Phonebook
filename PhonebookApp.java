import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhonebookApp {

    private static Map<String, String> phonebook = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nPhonebook Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Update Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. View Contacts");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    updateContact(scanner);
                    break;
                case 3:
                    deleteContact(scanner);
                    break;
                case 4:
                    viewContacts();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting phonebook. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }


    private static void addContact(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        if (phonebook.containsKey(name)) {
            System.out.println("Contact already exists. Use update option to change the phone number.");
        } else {
            phonebook.put(name, phone);
            System.out.println("Contact added successfully.");
        }
    }

    private static void updateContact(Scanner scanner) {
        System.out.print("Enter name of the contact to update: ");
        String name = scanner.nextLine();

        if (phonebook.containsKey(name)) {
            System.out.print("Enter new phone number: ");
            String newPhone = scanner.nextLine();
            phonebook.put(name, newPhone);
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void deleteContact(Scanner scanner) {
        System.out.print("Enter name of the contact to delete: ");
        String name = scanner.nextLine();

        if (phonebook.remove(name) != null) {
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void viewContacts() {
        if (phonebook.isEmpty()) {
            System.out.println("Phonebook is empty.");
        } else {
            System.out.println("\nContacts:");
            for (Map.Entry<String, String> entry : phonebook.entrySet()) {
                System.out.println("Name: " + entry.getKey() + ", Phone: " + entry.getValue());
            }
        }
    }
}
