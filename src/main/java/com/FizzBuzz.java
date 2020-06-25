package com;

public class FizzBuzz {


	public String getResult(int i) {
		boolean divisibleByFive = i % 5 == 0;

		String output = "BooYa";
		if (isDivisibleByThree(i) && divisibleByFive) {
			System.out.println(i);
			output = "fizzbuzz";
		} else if (isDivisibleByThree(i)) {
			System.out.println(i);
			output = "fizz";
		} else if (divisibleByFive) {
			System.out.println(i);
			output = "buzz";
		}
		return output;

	}

	private boolean isDivisibleByThree(int i) {
		return i % 3 == 0;
	}
}
