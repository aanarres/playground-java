package xyz.anarres.leetcode.dailychallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * @author anarres
 *
 */
public class PhoneLetters {
	public List<String> letterCombinations(String digits) {
		List<String> combos = new ArrayList<String>();
		if (digits.length() < 1)
			return combos;
		
		String[][] letters = {{}, {}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j","k","l"}, {"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"x","y","z"}};
		
		for(int i=0; i < digits.length(); i++) {
			int digit = Integer.parseUnsignedInt(digits.substring(i,i+1));
			if (letters[digit].length < 1)
				continue;
			
			if (combos.size() == 0) {
				for (int j=0; j<letters[digit].length;j++) {
					combos.add(letters[digit][j]);
				}
				continue;
			}
			
			ArrayList<String>newcombos = new ArrayList<>();
			for (int j=0; j<letters[digit].length; i++) {
				// add this letter to a replica of the current contents
					for (String string : combos) {
						newcombos.add(string + letters[digit][j]);
				}
			}
			combos = newcombos;
		}
		
		return combos;
	}
}
