package com.inventorybilling.model;

public class PurchaseDetail {

    private Product product;
    private int quantity;
    private double unitCost;

    public PurchaseDetail(Product product, int quantity, double unitCost) {
        this.product = product;
        this.quantity = quantity;
        this.unitCost = unitCost;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitCost() {
        return unitCost;
    }
}
