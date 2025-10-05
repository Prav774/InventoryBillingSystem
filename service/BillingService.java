package com.inventorybilling.service;

import com.inventorybilling.model.*;

public class BillingService {

    private InventoryService inventory;

    public BillingService(InventoryService inventory) {
        this.inventory = inventory;
    }

    public void makeSale(Customer customer, Product product, int qty) {
        if (product.getQuantity() < qty) {
            System.out.println("❌ Insufficient stock for product: " + product.getName());
            return;
        }

        Sale sale = new Sale(customer);
        SaleDetail detail = new SaleDetail(product, qty);
        sale.addSaleDetail(detail);
        inventory.updateStockAfterSale(product, qty);
        sale.printBill();
    }

    public void makePurchase(Product product, int qty, double cost) {
        Purchase purchase = new Purchase();
        PurchaseDetail detail = new PurchaseDetail(product, qty, cost);
        purchase.addPurchaseDetail(detail);
        inventory.updateStockAfterPurchase(product, qty);
        System.out.println("✅ Purchase recorded. Total Cost: ₹" + purchase.getTotalCost());
    }
}
