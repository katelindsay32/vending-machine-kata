package com.services;

import com.models.Inventory;
import com.repository.InventoryRepository;

public class InventoryService {
    private InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {

        this.inventoryRepository = inventoryRepository;
    }

    public String GetInventoryForSelection(String selection) {
        Inventory inventory = inventoryRepository.GetInventoryForSelection(selection);

        if(inventory.getInventoryAtSlot() == 0){
            return "";
        }
        return inventory.getProduct();
    }

    public void Dispense(String selection) {

    }
}
