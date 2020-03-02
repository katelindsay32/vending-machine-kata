package com.services;

import com.models.Inventory;
import com.repository.InventoryRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
        inventoryService.GetInventoryForSelection(selection);

        verify(inventoryRepository).GetInventoryForSelection(selection);
    }
}
