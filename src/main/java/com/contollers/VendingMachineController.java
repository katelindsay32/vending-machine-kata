package com.contollers;

import com.services.ProductService;

public class VendingMachineController {

	private ProductService productService;

	public VendingMachineController(ProductService productService) {

		this.productService = productService;
	}

	public String dispense() {
		boolean productAvailable = productService.isProductAvailable();
		return productAvailable ? "Diet Coke" : "";
	}
}
