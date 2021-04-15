package xyz.anarres.leetcode.dailychallenge;

/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 * 
 * Given a sequence of words written in the alien language, and the order of the alphabet, 
 * return true if and only if the given words are sorted lexicographicaly in this alien language.
 * 
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.)
According to lexicographical rules "apple" > "app".
 *
 */
public class AlienDictionary {

	public boolean isAlienSorted(String[] words, String order) {
		for (int i=1; i<words.length; i++) {
			AlienWord word = new AlienWord(words[i-1], order);
			if (word.compareTo(words[i]) > 0)
				return false;
		}
		return true;
	}

	private class AlienWord implements Comparable<String> {
		String word, order;
		
		AlienWord (String word, String order) {
			this.word = word;
			this.order = order;
		}

		@Override
		public int compareTo(String str) {

			if (word.equals(str))
				return 0;
			
			for (int i=0; i<=word.length()-1; i++) {
				// each letter, compared to the order if different
				if (str.length() <= i)
					return 1; // we finished the second and continue the first, so the first is "higher"
				if (word.charAt(i) == str.charAt(i))
					continue;
				int pos1 = order.indexOf(word.charAt(i));
				int pos2 = order.indexOf(str.charAt(i));
				return (pos1 < pos2) ? -1 : 1;
			}
			return 0;
		}
	}
}
