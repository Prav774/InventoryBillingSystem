package com.inventorybilling.model;

public class Customer {

    protected int id;
    protected String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return false;
    }
}
