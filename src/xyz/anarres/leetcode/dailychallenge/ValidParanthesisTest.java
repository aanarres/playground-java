package xyz.anarres.leetcode.dailychallenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidParanthesisTest {
	ValidParanthesis validcheck;

	@BeforeEach
	void setUp() throws Exception {
		validcheck = new ValidParanthesis();
	}

	@Test
	void testLongestValidParentheses() {
		String s = "(()";
		System.out.println(s);
		assertEquals(validcheck.longestValidParentheses(s), 2);
		
		s = ")()())";
		System.out.println(s);
		assertEquals(validcheck.longestValidParentheses(s), 4);
		
		s = "";
		System.out.println(s);
		assertEquals(validcheck.longestValidParentheses(s), 0);
	}

}
