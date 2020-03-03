package com.controllers;

import com.models.Coin;
import com.services.CoinService;
import com.services.InventoryService;

import java.util.ArrayList;

public class VendingMachineController {
    private InventoryService inventoryService;
    private CoinService coinService;

    public VendingMachineController(InventoryService inventoryService, CoinService coinService) {
        this.inventoryService = inventoryService;
        this.coinService = coinService;
    }

    public String Purchase(String selection, ArrayList<Coin> coins) {
        String product = inventoryService.GetInventoryForSelection(selection);
        coinService.ValidateCoins(coins);
        inventoryService.Dispense(selection);
        return product;
    }
}
