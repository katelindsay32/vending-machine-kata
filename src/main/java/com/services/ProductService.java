package com.services;

import com.repository.ProductRepository;

public class ProductService {


	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {

		this.productRepository = productRepository;
	}

	public boolean isProductAvailable() {
		int productCount = productRepository.getInventory();
		return productCount > 0;

	}
}
