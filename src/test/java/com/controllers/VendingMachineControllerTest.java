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

       verify(inventoryService).GetInventoryForSelection(selection);
    }

    @Test
    public void shouldGetProductNameWhenPurchaseRequested(){
        selection = "A1";
        product = "SNICKERS";

        when(inventoryService.GetInventoryForSelection(selection)).thenReturn(product);
        String result = controller.Purchase(selection, emptyListCoins);

        assertEquals(product, result);
    }

    @Test
    public void shouldDispenseProduct(){
        selection = "A1";
        product = "SNICKERS";

        when(inventoryService.GetInventoryForSelection(selection)).thenReturn(product);

        String result = controller.Purchase(selection, emptyListCoins);

        verify(inventoryService).Dispense(selection);
    }

    @Test
    public void shouldValidateCoins(){
        selection = "A1";

        ArrayList<Coin> coins = new ArrayList<Coin>();
        String result = controller.Purchase(selection, coins);

        verify(coinService).ValidateCoins(coins);
    }

}