package com.services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.models.Coin;

public class FundsServiceTest {

	private FundsService fundsService;

	@Before
	public void setUp() throws Exception {
		fundsService = new FundsService();
	}

	@Test
	public void whenCoinHasValidDiameterShouldReturnIsValid() {

		boolean isValid = fundsService.isValidCoin(Coin.DOLLAR);
		assertTrue(isValid);
	}

	@Test
	public void whenCoinHasValidWeightShouldReturnIsValid() {

		boolean isValid = fundsService.isValidCoin(Coin.DOLLAR);
		assertTrue(isValid);
	}

	@Test
	public void whenCoinHasInValidWeighShouldReturnIsNotValid() {
		Coin coin = new Coin(8.1,1,1);
		boolean isValid = fundsService.isValidCoin(coin);
		assertFalse(isValid);
	}

	@Test
	public void whenCoinHasInValidDiameterShouldReturnIsNotValid() {
		Coin coin = new Coin(1,1,1);
		boolean isValid = fundsService.isValidCoin(coin);
		assertFalse(isValid);
	}


}
