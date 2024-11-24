import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerManager customerManager = new CustomerManager();

        int choice;
        do {
            System.out.println("\n=== Customer Management System ===");
            System.out.println("1. Add Customer");
            System.out.println("2. List Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Search Customer");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    customerManager.addCustomer(scanner);
                    break;
                case 2:
                    customerManager.listCustomers();
                    break;
                case 3:
                    customerManager.updateCustomer(scanner);
                    break;
                case 4:
                    customerManager.deleteCustomer(scanner);
                    break;
                case 5:
                    customerManager.searchCustomer(scanner);
                    break;
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
