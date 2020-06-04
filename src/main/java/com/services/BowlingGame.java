package com.services;

public class BowlingGame {

	int[] rolls = new int[21];
	int currentRoll = 0;

	public void roll(int pins) {

		rolls[currentRoll] = pins;
		currentRoll++;
	}

	public int getScore() {
		int score = 0;

		int rollIndex = 0;
		for (int frame = 0; frame < 10; frame++) {
			if (isStrike(rolls[rollIndex])) {
				score += computeScoreForStrike(rollIndex);
				rollIndex += 1;
			}
			else if (isSpare(rollIndex)) {
				score += computeScoreForSpare(rollIndex);
				rollIndex += 2;
			} else {
				score += computeScoreForFrame(rollIndex);
				rollIndex += 2;
			}
		}
		return score;
	}

	private int computeScoreForFrame(int rollIndex) {
		return rolls[rollIndex] + rolls[rollIndex + 1];
	}

	private int computeScoreForSpare(int rollIndex) {
		return rolls[rollIndex] + rolls[rollIndex + 1] + rolls[rollIndex + 2];
	}

	private int computeScoreForStrike(int rollIndex) {
		return rolls[rollIndex] + rolls[rollIndex + 1] + rolls[rollIndex + 2];
	}

	private boolean isStrike(int roll) {
		return roll == 10;
	}

	private boolean isSpare(int i) {
		return computeScoreForFrame(i) == 10;
	}
}
