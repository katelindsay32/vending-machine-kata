package com.controllers;

import org.junit.Test;

import com.models.Coin;
import com.services.CoinService;
import com.services.ProductService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class VendingMachineControllerTest {

	CoinService coinService = mock(CoinService.class);
	ProductService productService = mock(ProductService.class);
	VendingMachineController controller = new VendingMachineController(coinService,productService);


	@Test
	public void controllerShouldTalkToCoinService(){

		Coin coin = new Coin(1, 1, 1);
		controller.Purchase(coin);
		verify(coinService).VerifyCoinIsQuarter(coin);
	}

	@Test
	public void controllerShouldTalkToProductServiceWhenCoinIsValid(){
		Coin coin = new Coin(1, 1, 1);
		when(coinService.VerifyCoinIsQuarter(coin)).thenReturn(true);
		controller.Purchase(coin);
		verify(productService).getProduct();
	}

	@Test
	public void controllerShouldNotTalkToProductServiceWhenCoinIsInValid(){
		Coin coin = new Coin(1, 1, 1);
		when(coinService.VerifyCoinIsQuarter(coin)).thenReturn(false);
		controller.Purchase(coin);
		verify(productService, never()).getProduct();
	}

}
