package com.controllers;

import com.models.Inventory;
import com.services.InventoryService;

public class VendingMachineController {
    private InventoryService inventoryService;

    public VendingMachineController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public Inventory Purchase(String selection) {
        return null;
    }
}
