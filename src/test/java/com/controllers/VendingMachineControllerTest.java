package com.controllers;

import com.models.Inventory;
import com.services.InventoryService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class VendingMachineControllerTest {

    private InventoryService inventoryService;
    private VendingMachineController controller;

    @Before
    public void Setup() {
        inventoryService = mock(InventoryService.class);
        controller = new VendingMachineController(inventoryService);
    }

    @Test
    public void shouldCheckInventoryWhenPurchaseRequested() {
        String selection = "A1";
        controller.Purchase(selection);

       verify(inventoryService).GetInventoryForSelection(selection);
    }

    @Test
    public void shouldGetProductNameWhenPurchaseRequested(){
        String selection = "A1";
        String product = "SNICKERS";
        when(inventoryService.GetInventoryForSelection(selection)).thenReturn(product);
        String result = controller.Purchase(selection);

        assertEquals(product, result);
    }
}