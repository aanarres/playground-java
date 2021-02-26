package xyz.anarres.algos;

/**
 * You are a product manager and currently leading a team to develop a new product. 
 * Unfortunately, the latest version of your product fails the quality check. Since
 * each version is developed based on the previous version, all the versions after
 * a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad
 * one, which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number
 * of calls to the API.
 */
public class VersionControl {
	int n = 5;
	int badVersion = 4;

	/* The isBadVersion API is defined in the parent class VersionControl.
	boolean isBadVersion(int version); */
	boolean isBadVersion(int version) {
		if (version >= badVersion)
			return true;
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VersionControlSolution solution = new VersionControlSolution(); 
		// base case
		System.out.println("n=" + solution.n + " and badVersion=" + solution.badVersion + ": bad=" + solution.firstBadVersion(solution.n));
		
		solution.n = 1; solution.badVersion = 1;
		System.out.println("n=" + solution.n + " and badVersion=" + solution.badVersion + ": bad=" + solution.firstBadVersion(solution.n));
		
	}
}


class VersionControlSolution extends VersionControl {
	public int firstBadVersion(int n) {
		
		// n can be maxint, mkay
		long lowest = 1; long highest = n;
		if (isBadVersion(1))
			return 1;
		
		do {
			long middle = (lowest + highest) / 2;
			if (isBadVersion((int)middle)) {
				// middle is bad, so first bad version is to the left of it
				highest = middle;
			}
			else {
				// middle is good, so the first bad version is to the right of it
				lowest = middle + 1;
			}
		} while (lowest < highest);
		
		// if they're the same, we may have found the bad apple
		if (lowest != n + 1 && isBadVersion((int)lowest))
			return (int)lowest;
		
		return 1;
	}
}
