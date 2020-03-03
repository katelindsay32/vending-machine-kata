package com.controllers;

import com.models.Coin;
import com.services.CoinService;
import com.services.InventoryService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class VendingMachineControllerTest {

    private InventoryService inventoryService;
    private VendingMachineController controller;
    private String selection;
    private String product;
    private CoinService coinService;
    private ArrayList<Coin> emptyListCoins;

    @Before
    public void Setup() {
        inventoryService = mock(InventoryService.class);
        coinService = mock(CoinService.class);
        controller = new VendingMachineController(inventoryService, coinService);
        emptyListCoins = new ArrayList<>();
    }

    @Test
    public void shouldCheckInventoryWhenPurchaseRequested() {
        String selection = "A1";
        controller.Purchase(selection, emptyListCoins);

        verify(inventoryService).canVendSelection(selection);
    }

    @Test
    public void shouldDispenseProductWhenAvailable() {
        selection = "A1";

        when(inventoryService.canVendSelection(selection)).thenReturn(true);

        controller.Purchase(selection, emptyListCoins);

        verify(inventoryService).Dispense(selection);
    }

    @Test
    public void shouldNotDispenseProductWhenNotAvailable() {
        selection = "A1";

        when(inventoryService.canVendSelection(selection)).thenReturn(false);

        controller.Purchase(selection, emptyListCoins);

        verify(inventoryService, never()).Dispense(selection);
    }


    @Test
    public void shouldValidateCoins() {
        selection = "A1";

        ArrayList<Coin> coins = new ArrayList<Coin>();
        controller.Purchase(selection, coins);

        verify(coinService).ValidateCoins(coins);
    }

}