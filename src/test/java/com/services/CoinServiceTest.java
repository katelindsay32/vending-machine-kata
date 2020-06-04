package com.services;

import static com.models.Coin.QUARTER;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.models.Coin;

public class CoinServiceTest {

	private CoinService coinService;

	@Before
	public void Setup(){
		coinService = new CoinService();
	}

	@Test
	public void validQuarterShouldHaveCorrectWeightAndDiameter() {
		boolean isValid = coinService.isValidCoin(QUARTER);
		assertTrue(isValid);
	}

	@Test
	public void invalidQuarterShouldHaveIncorrectWeight() {
		double invalidQuarterWeight = 24.2;
		Coin coin = new Coin(QUARTER.diameter.doubleValue(), invalidQuarterWeight, .25);
		boolean isValid = coinService.isValidCoin(coin);
		assertFalse(isValid);
	}

	@Test
	public void invalidQuarterShouldHaveIncorrectDiameter() {
		int invalidQuarterDiameter = 1;
		Coin coin = new Coin(invalidQuarterDiameter, QUARTER.weight.doubleValue(), .25);
		boolean isValid = coinService.isValidCoin(coin);
		assertFalse(isValid);
	}
}