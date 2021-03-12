package xyz.anarres.leetcode.march;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Alice has n candies, where the ith candy is of type candyType[i].
 * Alice noticed that she started to gain weight, so she visited a doctor.
 * The doctor advised Alice to only eat n / 2 of the candies she has (n is always even).
 * Alice likes her candies very much, and she wants to eat the maximum number of different
 * types of candies while still following the doctor's advice.
 * 
 * Given the integer array candyType of length n, return the maximum number of different
 * types of candies she can eat if she only eats n / 2 of them.
 * 
 * Input: candyType = [1,1,2,2,3,3]
 * Output: 3
 * Explanation: Alice can only eat 6 / 2 = 3 candies. Since there are only 3 types, she can eat one of each type.
 * 
 * Input: candyType = [1,1,2,3]
 * Output: 2
 * 
 * Input: candyType = [6,6,6,6]
 * Output: 1
 */
public class CandyGame {

	public static void main(String[] args) {
		// tests
		CandyGame candies = new CandyGame();
		int[] candyType = new int[] { 1, 1, 2, 2, 3, 3 };
		System.out.println(Arrays.toString(candyType) + " : " + candies.distributeCandies(candyType));
		
		candyType = new int[] { 1, 1, 2, 3 };
		System.out.println(Arrays.toString(candyType) + " : " + candies.distributeCandies(candyType));
		
		candyType = new int[] { 6, 6, 6, 6 };
		System.out.println(Arrays.toString(candyType) + " : " + candies.distributeCandies(candyType));
	}

	/**
	 * straightforward solution, array is not necessarily sorted so sort it beforehand
	 * @param candyType
	 * @return
	 */
	public int distributeCandiesDumb(int[] candyType) {
		if (candyType == null || candyType.length == 0)
			return 0; // out of candies!
		
		Arrays.sort(candyType);
		int canEat = candyType.length / 2;
		
		int k = 0;
		int type = -1;
		for (int i = 0; i < candyType.length; i++) {
			// as long as k < canEat, we can grab another, if any
			if (k < canEat && type != candyType[i]) {
				// we can grab this one
				k++;
				type = candyType[i];
				continue;
			} else if (k == canEat) {
				// enough, Alice
				return k;
			}
		}
		return k;
	}
	
	/** less memory usage, more runtime
	 * 
	 * @param candyType
	 * @return
	 */
	public int distributeCandies(int[] candyType) {
		if (candyType == null || candyType.length == 0)
			return 0; // out of candies!
		
		int canEat = candyType.length / 2;
		
		int k = 0;
		TreeSet<Integer> candies = new TreeSet<>();
		for (int candy:candyType) {
			// as long as k < canEat, we can grab another, if any
			if (k < canEat && candies.add(candy)) {
				k++;
				continue;
			} else if (k == canEat) {
				// enough, Alice
				return k;
			}
		}
		return k;
	}
}
