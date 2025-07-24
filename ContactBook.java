import java.util.ArrayList;
import java.util.Scanner;

// Contact class to hold name and number
class Contact {
    String name;
    String phoneNumber;

    Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    void display() {
        System.out.println("Name: " + name + ", Phone: " + phoneNumber);
    }
}

public class ContactBook {
    public static void main(String[] args) {
        ArrayList<Contact> contactList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Contact Book ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();
                    contactList.add(new Contact(name, phone));
                    System.out.println("Contact added successfully!");
                    break;

                case 2:
                    System.out.println("\nAll Contacts:");
                    if (contactList.isEmpty()) {
                        System.out.println("No contacts found.");
                    } else {
                        for (Contact c : contactList) {
                            c.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;
                    for (Contact c : contactList) {
                        if (c.name.equalsIgnoreCase(searchName)) {
                            c.display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine();
                    found = false;
                    for (int i = 0; i < contactList.size(); i++) {
                        if (contactList.get(i).name.equalsIgnoreCase(deleteName)) {
                            contactList.remove(i);
                            System.out.println("Contact deleted.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Contact Book. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
