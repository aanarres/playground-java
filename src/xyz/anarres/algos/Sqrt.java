package xyz.anarres.algos;


/**
 * Given a non-negative integer x, compute and return the square root of x.
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 */
public class Sqrt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test values, up to maxint
		int[] xarray = new int[] {4, 8, 0, 1, 3, 6, 2147395599, 36, 9, 2147483647};
		for (int x : xarray) {
			System.out.println("sqrt(" + x + ")=" + mySqrt(x));
		}
	}
	
	public static int mySqrt(int x) {
		// sqrt is the highest int whose power 2 is smaller or equal to x
		if (x * x == x)
			return x;
		
		long highend = x;
		long lowend = 1;
		
		long sqrt;
		do {
			sqrt = (highend + lowend) / 2;
			System.out.println("testing sqrt="+sqrt+" for lowend=" +lowend+ " and highend=" + highend);

			if (sqrt * sqrt <= x) {
				// found it if the next is too big
				if ((sqrt + 1) * (sqrt + 1) > x)
					return (int)sqrt;
				// otherwise, we continue in the upper branch, between sqrt and highend
				lowend = sqrt + 1;
			}
			else {
				highend = sqrt - 1;
			}
		} while (highend >= lowend);
		return 1;
	}
	
	public static int mySqrtDumb(int x) {
		// sqrt is required to be integer
		int sqrt = x;

		do {
			if (sqrt * sqrt <= x) {
				// found it
				break;
			}
			sqrt -= 1;
		}
		while (true);
		
		return sqrt;
	}
}
