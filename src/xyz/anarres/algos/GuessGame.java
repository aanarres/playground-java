package xyz.anarres.algos;

/**
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 * You call a pre-defined API int guess(int num), which returns 3 possible results:
 * 
 * -1: The number I picked is lower than your guess (i.e. pick < num).
 *  1: The number I picked is higher than your guess (i.e. pick > num).
 *   0: The number I picked is equal to your guess (i.e. pick == num).
 *   
 * Return the number that I picked.
 */
public class GuessGame {
	private static final int n = 2126753390;
	private int choice = (int)(Math.random() * (n-1) + 1);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// guess the choice, assuming integer up to n
		
		GuessGame guessGame = new GuessGame();
		GuessGame.Solution solution = guessGame.new Solution();
		
		System.out.println("Pssst n=" + n + " choice=" + guessGame.choice);
		
		System.out.println("Got it: " + guessGame.choice + "=" + solution.guessNumber(n));

	}
	
	class Solution {
		int guessNumber(int n) {
			// guess the choice, assuming integer up to n
			long num; // because reasons, I mean operations back n forth
			long lowest = 1; long highest = n;
			
			do {
				num = (lowest + highest) / 2;
				System.out.print("Trying " + num);
				
				int guess = guess((int)num);
				if (guess == 0) {
					System.out.println(" yay");
					return (int)num;
				}
				if (guess == 1) {
					// guess is too low, look up higher range
					lowest = num + 1;
					System.out.println("...too low, now from lowest=" + lowest + ", where highest=" + highest);
					System.out.println();
				}
				else {
					// guess is too high, look up lower range
					highest = num - 1;
					System.out.println("...too high, now from highest=" + highest + ", where lowest=" + lowest);
				}
			}
			while (lowest <= highest);
			
			// throw new RuntimeException("oops");
			return (int)num;
		}
	}
	
	
	/** 
	 * Forward declaration of guess API.
	 * @param  num   your guess
	 * @return 	     -1 if num is lower than the guess number
	 *			      1 if num is higher than the guess number
	 *               otherwise return 0
	 * int guess(int num);
	 */
	private int guess(int num) {
		if (num == choice)
			return 0;
		if (num < choice)
			return 1;
		return -1;
	}
}
