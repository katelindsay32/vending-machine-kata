package com.Controllers;

import static com.models.Coin.QUARTER;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import com.services.CoinService;

//VendingMachineController -> CoinService
//							-> ProductService

//first pass:
//use case: As a thirsty person, I can purchase a Diet Coke for One Quarter

//Controller accepts a coin
//Checks with CoinService if that Coin is a valid quarter
//Check with Product Service that we have DietCoke still in stock
//return product

//no change.

public class VendingMachineControllerTest {

	private VendingMachineController vendingMachineController;

	@Test
	public void whenPurchaseProductCallCoinService_test(){
		CoinService coinService = mock (CoinService.class);
		vendingMachineController = new VendingMachineController(coinService);
		vendingMachineController.puchase(QUARTER);
		verify(coinService).isValidCoin(QUARTER);
	}

}
