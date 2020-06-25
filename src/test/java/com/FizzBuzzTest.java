package com;

import static org.junit.Assert.*;

import org.junit.Test;

public class FizzBuzzTest {

	@Test
	public void givenANumberDivisibleByThree(){
		FizzBuzz fizzBuzz = new FizzBuzz();
		String result = fizzBuzz.getResult(9);
		assertEquals("fizz", result);
	}
	@Test
	public void givenANumberDivisibleByFive(){
		FizzBuzz fizzBuzz = new FizzBuzz();
		String result = fizzBuzz.getResult(10);
		assertEquals("buzz", result);
	}@Test
	public void givenANumberDivisibleByThreeAndFive(){
		FizzBuzz fizzBuzz = new FizzBuzz();
		String result = fizzBuzz.getResult(15);
		assertEquals("fizzbuzz", result);
	}

}
