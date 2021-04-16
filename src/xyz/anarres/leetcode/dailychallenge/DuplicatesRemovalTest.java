package xyz.anarres.leetcode.dailychallenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DuplicatesRemovalTest {
	DuplicatesRemoval removal;

	@BeforeEach
	void setUp() throws Exception {
		removal = new DuplicatesRemoval();
	}

	@Test
	void testRemoveDuplicates() {
		assertEquals("abcd", removal.removeDuplicates("abcd", 2));
		assertEquals("aa", removal.removeDuplicates("deeedbbcccbdaa", 3));
		assertEquals("ps", removal.removeDuplicates("pbbcggttciiippooaais", 2));
		assertEquals("ybth", removal.removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4));
	}
}
