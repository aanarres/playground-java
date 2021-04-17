package xyz.anarres.leetcode.dailychallenge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PhoneLettersTest {
	PhoneLetters phone;

	@BeforeEach
	void setUp() throws Exception {
		phone = new PhoneLetters();
	}

	@Test
	void testLetterCombinations() {
		List<String> result = phone.letterCombinations("23");
		String[] exp = {"ad","ae","af","bd","be","bf","cd","ce","cf"};
		assertEquals(exp.length, result.size());
		for (String expected:exp) {
			assertTrue(result.contains(expected));
		}
		
		// empty case
		List<String> result2 = phone.letterCombinations("");
		assertEquals(result2.size(), 0);
		
		List<String> result3 = phone.letterCombinations("2");
		String[] exp3 = {"a","b","c"};
		assertEquals(exp3.length, result3.size());
		for (String expected:exp3) {
			assertTrue(result3.contains(expected));
		}
	}
}
