package com.services;

import com.models.Inventory;
import com.repository.InventoryRepository;

public class InventoryService {
    private InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {

        this.inventoryRepository = inventoryRepository;
    }

    public boolean canVendSelection(String selection) {
        Inventory inventory = inventoryRepository.GetInventoryForSelection(selection);

        return inventory.getInventoryAtSlot() > 0;
    }

    public void Dispense(String selection) {

    }
}
