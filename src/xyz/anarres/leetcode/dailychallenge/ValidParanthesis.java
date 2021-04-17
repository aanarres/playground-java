package xyz.anarres.leetcode.dailychallenge;

/**
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * 
 * @author anarres
 *
 */
public class ValidParanthesis {
	public int longestValidParentheses(String s) {
		int max = 0;
		if (s.length() < 1)
			return 0;
		
		// ok simple things simple: try to follow valid for each char
		int k = 0;
		while (k < s.length() - 1) {
			// we're starting here, a closed ) is not valid
			if (s.substring(k, k+1).equals(")")) {
				k++;
				continue;
			}
			
			int count = 0;
			int open = 0;
			for (int i=k; i<s.length();i++) {
				if (s.substring(i, i+1).equals("("))
					open++;
				else
					open--;
				// if it's invalid already, give it up
				if (open < 0)
					break;
				
				count++;
				
				// if it's a valid sequence, update max
				if (open == 0 && count > max)
					max = count;
			}
			k++;
		}
		return max;
	}
}
