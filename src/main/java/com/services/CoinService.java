package com.services;

import com.models.Coin;

public class CoinService {
	public boolean VerifyCoinIsQuarter(Coin coin) {
		return Coin.QUARTER.weight.equals(coin.weight);
	}
}
