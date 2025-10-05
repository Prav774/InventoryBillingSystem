package com.inventorybilling.model;

import java.util.ArrayList;
import java.util.List;

public class Sale {

    private Customer customer;
    private List<SaleDetail> details;

    public Sale(Customer customer) {
        this.customer = customer;
        this.details = new ArrayList<>();
    }

    public void addSaleDetail(SaleDetail detail) {
        details.add(detail);
    }

    public double getTotalBeforeTax() {
        return details.stream().mapToDouble(SaleDetail::getSubtotal).sum();
    }

    public double getTotalTax() {
        return details.stream().mapToDouble(SaleDetail::getTax).sum();
    }

    public double getTotalAmount() {
        return getTotalBeforeTax() + getTotalTax();
    }

    public void printBill() {
        System.out.println("\n===== SALE BILL =====");
        System.out.println("Customer: " + customer.getName());
        System.out.println("---------------------------");

        for (SaleDetail d : details) {
            System.out.printf("%s (x%d) - ₹%.2f\n", d.getProduct().getName(),
                    d.getQuantity(), d.getSubtotal());
        }

        double subtotal = getTotalBeforeTax();
        double tax = getTotalTax();
        double discount = 0;

        if (customer instanceof PremiumCustomer pc) {
            discount = pc.applyDiscount();
            pc.addPoints(subtotal - discount);
            System.out.println("Reward Points: " + pc.getRewardPoints());
        }

        double total = subtotal + tax - discount;

        System.out.println("---------------------------");
        System.out.printf("Subtotal: ₹%.2f\n", subtotal);
        System.out.printf("Tax: ₹%.2f\n", tax);
        System.out.printf("Discount: ₹%.2f\n", discount);
        System.out.printf("TOTAL: ₹%.2f\n", total);
        System.out.println("===========================");
    }
}
