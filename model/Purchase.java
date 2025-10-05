package com.inventorybilling.model;

import java.util.ArrayList;
import java.util.List;

public class Purchase {

    private List<PurchaseDetail> details;

    public Purchase() {
        this.details = new ArrayList<>();
    }

    public void addPurchaseDetail(PurchaseDetail detail) {
        details.add(detail);
    }

    public double getTotalCost() {
        return details.stream()
                .mapToDouble(d -> d.getUnitCost() * d.getQuantity())
                .sum();
    }
}
