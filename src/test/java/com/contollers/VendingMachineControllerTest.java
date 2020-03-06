package com.contollers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.services.ProductService;

public class VendingMachineControllerTest {

	ProductService productService = mock(ProductService.class);
	VendingMachineController controller = new VendingMachineController(productService);

	@Test
	public void whenWeDispenseShouldCallProductService(){
		controller.dispense();
		verify(productService).isProductAvailable();
	}

	@Test
	public void whenProductAvailableShouldReturnProduct() {
		when(productService.isProductAvailable()).thenReturn(true);
		String productName = controller.dispense();
		assertEquals("Diet Coke", productName);
	}

	@Test
	public void whenProductNotAvailableShouldReturnEmpty() {
		when(productService.isProductAvailable()).thenReturn(false);
		String productName = controller.dispense();
		assertEquals("", productName);
	}
}
