package com.Controllers;

import com.models.Coin;
import com.services.CoinService;

public class VendingMachineController {
	private CoinService coinService;

	public VendingMachineController(CoinService coinService) {

		this.coinService = coinService;
	}

	public void puchase(Coin coin) {
		coinService.isValidCoin(coin);
	}
}

