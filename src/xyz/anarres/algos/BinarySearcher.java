package xyz.anarres.algos;

import java.util.Arrays;

/**
 * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums.
 * If target exists, then return its index, otherwise return -1.
 */
public class BinarySearcher {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 
		int[] nums = new int[] {-1, 0, 3}; //, 5 ,9 ,12};
		int target = 3;
		int index = search(nums, target);
		System.out.println("Index of " + target + " in " + Arrays.toString(nums) + " is: " + index);
		
		target = 0;
		index = search(nums, target);
		System.out.println("Index of " + target + " in " + Arrays.toString(nums) + " is: " + index);
		
		target = 2;
		nums = new int[] {2, 5};
		index = search(nums, target);
		System.out.println("Index of " + target + " in " + Arrays.toString(nums) + " is: " + index);
		
	}
	
	public static int search(int[] nums, int target) {
		int index = -1; // memory usage, var for clarity
		
		// test with middle element
		int middle;
		int start = 0; int end = nums.length - 1;
		System.out.println(nums.length + " elements");
		
		do {
			middle = (start + end + 1) / 2;
			if (target == nums[middle]) {
				// found it
				index = middle;
				break;
			}
			if (target < nums[middle]) {
				// left sub-array
				end = middle - 1;
			} else {
				// right sub-array
				start = middle + 1;
			}
		}
		while (start <= end);

		return index;
	}


}
