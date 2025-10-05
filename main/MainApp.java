package com.inventorybilling.main;

import com.inventorybilling.model.*;
import com.inventorybilling.service.*;
import com.inventorybilling.util.InputUtil;

public class MainApp {

    public static void main(String[] args) {

        InventoryService inventory = new InventoryService();
        BillingService billing = new BillingService(inventory);

        while (true) {
            System.out.println("\n==== Inventory & Billing System ====");
            System.out.println("1. Add Product");
            System.out.println("2. Add Customer");
            System.out.println("3. Make a Purchase");
            System.out.println("4. Make a Sale");
            System.out.println("5. Display Products");
            System.out.println("6. Exit");

            int choice = InputUtil.getInt("Choose option: ");

            switch (choice) {
                case 1 -> {
                    int id = InputUtil.getInt("Enter product id: ");
                    String name = InputUtil.getString("Enter product name: ");
                    double price = InputUtil.getDouble("Enter price: ");
                    int qty = InputUtil.getInt("Enter quantity: ");
                    double tax = InputUtil.getDouble("Enter tax rate: ");

                    ProductTaxCategory cat = new ProductTaxCategory("General", tax);
                    Product p = new Product(id, name, price, qty, cat);
                    inventory.addProduct(p);
                    System.out.println("✅ Product added successfully.");
                }

                case 2 -> {
                    int id = InputUtil.getInt("Enter customer id: ");
                    String name = InputUtil.getString("Enter customer name: ");
                    String premium = InputUtil.getString("Is premium customer? (yes/no): ");
                    Customer c = premium.equalsIgnoreCase("yes")
                            ? new PremiumCustomer(id, name)
                            : new Customer(id, name);
                    inventory.addCustomer(c);
                    System.out.println("✅ Customer added successfully.");
                }

                case 3 -> {
                    int pid = InputUtil.getInt("Enter product id: ");
                    int qty = InputUtil.getInt("Enter quantity purchased: ");
                    double cost = InputUtil.getDouble("Enter unit cost: ");

                    Product product = inventory.getProductById(pid);
                    if (product != null) {
                        billing.makePurchase(product, qty, cost);
                    } else {
                        System.out.println("❌ Invalid product ID!");
                    }
                }

                case 4 -> {
                    int cid = InputUtil.getInt("Enter customer id: ");
                    int pid = InputUtil.getInt("Enter product id: ");
                    int qty = InputUtil.getInt("Enter quantity sold: ");

                    Customer cust = inventory.getCustomerById(cid);
                    Product prod = inventory.getProductById(pid);

                    if (cust != null && prod != null) {
                        billing.makeSale(cust, prod, qty);
                    } else {
                        System.out.println("❌ Invalid customer or product ID!");
                    }
                }

                case 5 -> inventory.displayProducts();

                case 6 -> {
                    System.out.println("👋 Exiting system... Thank you!");
                    System.exit(0);
                }

                default -> System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }
}
