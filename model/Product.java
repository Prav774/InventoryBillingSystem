package com.inventorybilling.model;

public class Product {

    private int id;
    private String name;
    private double unitPrice;
    private int quantity;
    private ProductTaxCategory taxCategory;

    public Product(int id, String name, double unitPrice, int quantity, ProductTaxCategory taxCategory) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.taxCategory = taxCategory;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductTaxCategory getTaxCategory() {
        return taxCategory;
    }

    public void increaseStock(int qty) {
        this.quantity += qty;
    }

    public void decreaseStock(int qty) {
        this.quantity -= qty;
    }

    @Override
    public String toString() {
        return String.format("%d - %s | ₹%.2f | Qty: %d | Tax: %.1f%%",
                id, name, unitPrice, quantity, taxCategory.getRate());
    }
}
