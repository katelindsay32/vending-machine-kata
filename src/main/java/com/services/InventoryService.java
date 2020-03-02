package com.services;

import com.models.Inventory;
import com.repository.InventoryRepository;

public class InventoryService {
    private InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {

        this.inventoryRepository = inventoryRepository;
    }

    public String GetInventoryForSelection(String selection) {
        inventoryRepository.GetInventoryForSelection(selection);
        return null;
    }
}
