package com.services;

import com.models.Inventory;
import com.repository.InventoryRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class InventoryServiceTest {

    private InventoryRepository inventoryRepository;
    private InventoryService inventoryService;

    @Before
    public void Setup() {
        inventoryRepository = mock(InventoryRepository.class);
        inventoryService = new InventoryService(inventoryRepository);
    }

    @Test
    public void shouldGetInventoryFromRepo(){
        String selection = "A1";
        when(inventoryRepository.GetInventoryForSelection(selection)).thenReturn(new Inventory("SNICKERS", 2));

        inventoryService.GetInventoryForSelection(selection);

        verify(inventoryRepository).GetInventoryForSelection(selection);
    }

    @Test
    public void shouldReturnEmptyIfItemIsNotInStock(){
        String selection = "A1";
        when(inventoryRepository.GetInventoryForSelection(selection)).thenReturn(new Inventory("SNICKERS", 0));
        String result = inventoryService.GetInventoryForSelection(selection);
        assertTrue(result.isEmpty());
    }
}
