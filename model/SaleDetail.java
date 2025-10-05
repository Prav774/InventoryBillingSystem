package com.inventorybilling.model;

public class SaleDetail {

    private Product product;
    private int quantity;

    public SaleDetail(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return product.getUnitPrice() * quantity;
    }

    public double getTax() {
        return getSubtotal() * (product.getTaxCategory().getRate() / 100);
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
