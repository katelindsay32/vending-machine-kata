package com.models;

public class Inventory {
    private String product;
    private int inventoryAtSlot;

    public Inventory(String product, int inventoryAtSlot) {

        this.product = product;
        this.inventoryAtSlot = inventoryAtSlot;
    }

    public String getProduct() {
        return product;
    }

    public int getInventoryAtSlot() {
        return inventoryAtSlot;
    }
}
