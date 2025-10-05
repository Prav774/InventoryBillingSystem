package com.inventorybilling.service;

import com.inventorybilling.model.*;
import java.util.*;

public class InventoryService {

    private Map<Integer, Product> products = new HashMap<>();
    private Map<Integer, Customer> customers = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public Product getProductById(int id) {
        return products.get(id);
    }

    public Customer getCustomerById(int id) {
        return customers.get(id);
    }

    public void displayProducts() {
        System.out.println("\n===== PRODUCT LIST =====");
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }

    public void updateStockAfterPurchase(Product product, int qty) {
        product.increaseStock(qty);
    }

    public void updateStockAfterSale(Product product, int qty) {
        product.decreaseStock(qty);
    }
}
