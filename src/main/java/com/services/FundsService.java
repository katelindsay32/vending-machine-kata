package com.services;

import com.models.Coin;

public class FundsService {
	public boolean isValidCoin(Coin coin) {
		boolean isValid = Coin.VALID_COINS.stream().anyMatch(c -> hasValidWeightAndDiameter(c, coin));
		return isValid;
	}

	private boolean hasValidWeightAndDiameter(Coin coin, Coin c) {
		return diameterMatches(coin, c)
		&& weightMatch(coin, c);
	}

	private boolean weightMatch(Coin coin, Coin c) {
		return c.weight.compareTo(coin.weight) == 0;
	}

	private boolean diameterMatches(Coin coin, Coin c) {
		return c.diameter.compareTo(coin.diameter) == 0;
	}
}
