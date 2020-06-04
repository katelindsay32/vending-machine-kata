package com.services;

import static com.models.Coin.QUARTER;

import com.models.Coin;

public class CoinService {

	public boolean isValidCoin(Coin coin) {

		return coin.weight.equals(QUARTER.weight)
		&& coin.diameter.equals(QUARTER.diameter);
	}
}
