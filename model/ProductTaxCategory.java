package com.inventorybilling.model;

public class ProductTaxCategory {

    private String name;
    private double rate;

    public ProductTaxCategory(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }
}
