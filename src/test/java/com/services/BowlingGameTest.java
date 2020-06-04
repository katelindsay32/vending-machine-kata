package com.services;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingGameTest {

	BowlingGame game = new BowlingGame();


	@Test
	public void rollGutterGame(){
		rollMany(0, 20);

		int score = game.getScore();
		assertEquals(0, score);
	}

	@Test
	public void rollOneEachTime(){
		rollMany(1, 20);
		int score = game.getScore();
		assertEquals(20, score);
	}

	@Test
	public void rollOneSpare(){
		game.roll(5);
		game.roll(5);

		game.roll(1);

		rollMany(0, 17);

		int score = game.getScore();
		assertEquals(12, score);
	}

	@Test
	public void rollOneStrike(){
		game.roll(10);
		game.roll(1);
		game.roll(1);

		rollMany(0, 17);

		int score = game.getScore();
		assertEquals(14, score);
	}

	@Test
	public void perfectGame(){
		rollMany(10, 12);
		int score = game.getScore();
		assertEquals(300, score);
	}

	@Test
	public void luckyLastFrame(){
		rollMany(0, 18);
		game.roll(10);
		game.roll(10);
		game.roll(10);
		int score = game.getScore();
		assertEquals(30, score);
	}

	private void rollMany(int pins, int rolls) {
		for (int i = 0; i < rolls; i++) {
			game.roll(pins);
		}
	}

}
