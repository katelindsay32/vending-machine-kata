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
    private String selection;
    private String product;

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
        selection = "A1";
        product = "SNICKERS";

        when(inventoryService.GetInventoryForSelection(selection)).thenReturn(product);
        String result = controller.Purchase(selection);

        assertEquals(product, result);
    }

    @Test
    public void shouldDispenseProduct(){
        String selection = "A1";
        product = "SNICKERS";

        when(inventoryService.GetInventoryForSelection(selection)).thenReturn(product);
        String result = controller.Purchase(selection);

        verify(inventoryService).Dispense(selection);


    }

}