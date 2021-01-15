package com.ubs.assignment.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.ubs.assignment.model.PrimeGenerator;

public class TestCheckPrime {

	private final PrimeGenerator pgen = new PrimeGenerator();

	// Test Cases for checkPrime method

	@Test
	public void checkingSmallPrimes() {
		int[] numbers = { 5, 7, 11, 13, 17, 19, 23, 29 };

		for (int i = 0; i < numbers.length; i++) {
			assertEquals(pgen.checkPrime(numbers[i]), true);
		}

	}

	@Test
	public void checkingPositiveNotPrime() {
		int[] numbers = { 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25 };

		for (int i = 0; i < numbers.length; i++) {
			assertEquals(pgen.checkPrime(numbers[i]), false);
		}
	}

	@Test
	public void checkingBigPrimes() {
		int[] numbers = { 104677, 104681, 104683, 104693, 104701, 104707, 104711, 104717, 104723, 104729 };

		for (int i = 0; i < numbers.length; i++) {
			assertEquals(pgen.checkPrime(numbers[i]), true);
		}
	}

}
