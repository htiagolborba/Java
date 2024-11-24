import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManager {
    private ArrayList<Customer> customers;
    private int nextId;

    public CustomerManager() {
        customers = new ArrayList<>();
        nextId = 1;
    }

    public void addCustomer(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();

        Customer customer = new Customer(nextId++, name, email);
        customers.add(customer);
        System.out.println("Customer added successfully.");
    }

    public void listCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("=== List of Customers ===");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    public void updateCustomer(Scanner scanner) {
        System.out.print("Enter customer ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Customer customer = findCustomerById(id);
        if (customer != null) {
            System.out.print("Enter new name (leave blank to keep current): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                customer.setName(name);
            }

            System.out.print("Enter new email (leave blank to keep current): ");
            String email = scanner.nextLine();
            if (!email.isEmpty()) {
                customer.setEmail(email);
            }

            System.out.println("Customer updated successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void deleteCustomer(Scanner scanner) {
        System.out.print("Enter customer ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Customer customer = findCustomerById(id);
        if (customer != null) {
            customers.remove(customer);
            System.out.println("Customer deleted successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void searchCustomer(Scanner scanner) {
        System.out.print("Enter customer name to search: ");
        String name = scanner.nextLine();

        System.out.println("=== Search Results ===");
        for (Customer customer : customers) {
            if (customer.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(customer);
            }
        }
    }

    private Customer findCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}

