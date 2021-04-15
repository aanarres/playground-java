package xyz.anarres.leetcode.dailychallenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlienDictionaryTest {
	AlienDictionary dict;

	@BeforeEach
	void setUp() throws Exception {
		dict = new AlienDictionary();
	}

	@Test
	void testIsAlienSorted() {
		String[] words = {"hello", "leecode"};
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		assertTrue(dict.isAlienSorted(words, order));
		
		String[] words2 = {"word", "world", "row"};
		order = "worldabcefghijkmnpqstuvxyz";
		assertFalse(dict.isAlienSorted(words2, order));
		
		String[] words3 = {"apple","app"};
		order = "abcdefghijklmnopqrstuvwxyz";
		assertFalse(dict.isAlienSorted(words3, order));
	}

}
