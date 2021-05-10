package xyz.anarres.leetcode.dailychallenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrimeCounterTest {
	private PrimeCounter counter;

	@BeforeEach
	void setUp() throws Exception {
		counter = new PrimeCounter();
	}

	@Test
	void testCountPrimes() {
		assertEquals(4, counter.countPrimes(10));
		assertEquals(0, counter.countPrimes(1));
		assertEquals(0, counter.countPrimes(0));
	}

}
