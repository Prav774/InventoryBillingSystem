package com.inventorybilling.model;

public class PremiumCustomer extends Customer {

    private int rewardPoints;

    public PremiumCustomer(int id, String name) {
        super(id, name);
        this.rewardPoints = 0;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void addPoints(double amount) {
        this.rewardPoints += (int) (amount / 100);
    }

    public double applyDiscount() {
        double discount = 0;
        if (rewardPoints >= 200) {
            discount = (rewardPoints / 100) * 10;
            rewardPoints %= 100;
        }
        return discount;
    }

    @Override
    public boolean isPremium() {
        return true;
    }
}
