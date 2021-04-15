package xyz.anarres.leetcode.dailychallenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FibonacciTest {
	Fibonacci f = null;
	
	@BeforeEach
	void setUp() throws Exception {
		f = new Fibonacci();
	}

	@Test
	void testFib() {
		assertEquals(0, f.fib(0));
		assertEquals(1, f.fib(1));
		assertEquals(1, f.fib(2));
		assertEquals(2, f.fib(3));
		assertEquals(3, f.fib(4));
	}

}
