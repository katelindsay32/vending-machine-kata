package com.controllers;

import com.models.Coin;
import com.services.CoinService;
import com.services.ProductService;

public class VendingMachineController {
	private CoinService coinService;
	private ProductService productService;


	public VendingMachineController(CoinService coinService, ProductService productService) {

		this.coinService = coinService;
		this.productService = productService;
	}

	public void Purchase(Coin coin) {

		//accept coin
		//make sure its a quarter
		//if it is a quarter, we will ask product service for an item
		//return the item.

		boolean isValid = coinService.VerifyCoinIsQuarter(coin);
		if (isValid) {
			productService.getProduct();
		}


	}
}
