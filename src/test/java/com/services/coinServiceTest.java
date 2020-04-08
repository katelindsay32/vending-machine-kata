package com.services;

import static org.junit.Assert.*;

import org.junit.Test;

import com.models.Coin;

public class coinServiceTest {
	CoinService coinService = new CoinService();
	@Test
	public void coinWithInvalidWeightShouldBeInvalid(){
		Coin notAQuarter= new Coin(1,1,1);
		boolean isValid = coinService.VerifyCoinIsQuarter(notAQuarter);
		assertFalse(isValid);
	}

	@Test
	public void coinWIthValidWeightShouldBeValid(){
		Coin aQuarter = new Coin(1,24.26,1);
		boolean isValid = coinService.VerifyCoinIsQuarter(aQuarter);
		assertTrue(isValid);
	}
}
