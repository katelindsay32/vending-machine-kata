package com.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.repository.ProductRepository;

public class ProductServiceTest {

	ProductRepository productRepository = mock(ProductRepository.class);

	private ProductService productService =new ProductService(productRepository);


	@Test
	public void whenIsProductAvailableCalledShouldReturnTrueIfInventoryGreaterThanZero(){
		when(productRepository.getInventory()).thenReturn(5);
		boolean productAvailable = productService.isProductAvailable();
		assertTrue(productAvailable);
	}

	@Test
	public void
	whenIsProductAvailableCalledShouldReturnFalseIfInventoryEqualsZero(){
		when(productRepository.getInventory()).thenReturn(0);
		boolean productAvailable = productService.isProductAvailable();
		assertFalse(productAvailable);
	}




}
