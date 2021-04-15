package xyz.anarres.leetcode.dailychallenge;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. 
The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead,
the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to
the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given an integer, convert it to a roman numeral.
 *
 * 1 <= num <= 3999
 */
public class RomanNumber {
    enum digits { THOUSAND, HUNDRED, TEN, DIGIT };

	public static void main(String[] args) {
		// some tests
		RomanNumber roman = new RomanNumber();
		int[] nums = new int[] {3, 4, 9, 58, 1994, 400};
		
		for (int num: nums)
			System.out.println(num + " = " + roman.intToRoman(num));
		
	}
	
	public String intToRoman(int num) {
		StringBuffer sb = new StringBuffer();
		
		// all special cases, in descending order
		int[] specialInts = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] romanNumbers = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		
		for (int i=0; i<specialInts.length; i++) {
			while (num >= specialInts[i]) {
				// System.out.println(num + ">=" + specialInts[i] + " so add " + romanNumbers[i]);
				num = num - specialInts[i];
				sb.append(romanNumbers[i]);
			}
		}
		return sb.toString();
	}

	/**
	 * Convert to a Roman number.
	 * Dumb solution, just laying it all out
	 * @param num 1 <= num <= 3999
	 * @return Roman number
	 */
	public String intToRomanDumb(int num) {
		// the requirement consists in only integers before 4000, so there's a small number of digits and cases to handle.
		
		// thousands
		int digit = num / 1000; num = num % 1000;
		StringBuffer sb = new StringBuffer();
		sb.append(romanDigit(digit, digits.THOUSAND));
		
		// hundreds
		digit = num / 100; num = num % 100;
		sb.append(romanDigit(digit, digits.HUNDRED));
		
		// tens
		digit = num / 10; num = num % 10;
		sb.append(romanDigit(digit, digits.TEN));
		
		// digits
		digit = num;
		sb.append(romanDigit(digit, digits.DIGIT));
		
		return sb.toString();
	}
	String romanDigit(int digit, digits order) {
		if (digit == 0)
			return "";
		switch (digit) {
		case 1:
			switch (order) {
			case DIGIT: return "I";
			case TEN: return "X";
			case HUNDRED: return "C";
			case THOUSAND: return "M";
			}
		case 2:
			switch (order) {
			case DIGIT: return "II";
			case TEN: return "XX";
			case HUNDRED: return "CC";
			case THOUSAND: return "MM";
			}
		case 3: 
			switch (order) {
			case DIGIT: return "III";
			case TEN: return "XXX";
			case HUNDRED: return "CCC";
			case THOUSAND: return "MMM";
			}
		case 4: 
			switch (order) {
			case DIGIT: return "IV"; // 4
			case TEN: return "XL"; // 40
			case HUNDRED: return "CD"; // 400
			default: 
				System.out.println("Oops: got digit 4 with unknown order");
				break;
			}
		case 5:
			switch (order) {
			case DIGIT: return "V"; // 5
			case TEN: return "L"; // 50
			case HUNDRED: return "D"; // 500
			default: 
				System.out.println("Oops: got digit 5 with unknown order");
				break;
			}
		case 6:
			switch (order) {
			case DIGIT: return "VI"; // 6
			case TEN: return "LX"; // 60
			case HUNDRED: return "DC"; // 600
			default: 
				System.out.println("Oops: got digit 6 with unknown order");
				break;
			}
		case 7:
			switch (order) {
			case DIGIT: return "VII"; // 7
			case TEN: return "LXX"; // 70
			case HUNDRED: return "DCC"; // 700
			default: 
				System.out.println("Oops: got digit 7 with unknown order");
				break;
			}
		case 8:
			switch (order) {
			case DIGIT: return "VIII"; // 8
			case TEN: return "LXXX"; // 80
			case HUNDRED: return "DCCC"; // 800
			default: 
				System.out.println("Oops: got digit 8 with unknown order");
				break;
			}
		case 9:
			switch (order) {
			case DIGIT: return "IX"; // 9
			case TEN: return "XC"; // 90
			case HUNDRED: return "CM"; // 900
			default: 
				System.out.println("Oops: got digit 9 with unknown order");
				break;
			}
		default:
			System.out.println("Digit is not a digit! digit=" + digit);
			break;
		}
		
		return ""; // mysterious things happen
	}
}
