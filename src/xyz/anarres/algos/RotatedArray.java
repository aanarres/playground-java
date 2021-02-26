/**
 * 
 */
package xyz.anarres.algos;

import java.util.Arrays;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that:
   the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
   For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:

Input: nums = [1], target = 0
Output: -1

 */
public class RotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RotatedArray rotArray = new RotatedArray();
		// test examples
		int[] nums = new int[] {4,5,6,7,0,1,2};
		int target = 0;
		System.out.println("Index of " + target + " in " + Arrays.toString(nums) + " is: " + rotArray.search(nums, target));
		target = 3;
		System.out.println("Index of " + target + " in " + Arrays.toString(nums) + " is: " + rotArray.search(nums, target));
		
		nums = new int[] {1};
		target = 0;
		System.out.println("Index of " + target + " in " + Arrays.toString(nums) + " is: " + rotArray.search(nums, target));
	}

	public int search(int[] nums, int target) {
		
		// ordered partition ... unordered partition ... ordered partition
		
		int lowest = 0; int highest = nums.length - 1;
		
		do {
		int middle = (lowest + highest) / 2;
		
		// one partition is ordered, the other is not
		System.out.println("Testing first partition...");
		if (nums[lowest] <= nums[middle]) {
			// the lower partition is ordered
			// are we lucky?
			if (nums[lowest] <= target && nums[middle] >= target) {
				// hardest part is done, now regular binary search :P
				return binarySearch(nums, target, lowest, middle);
			}
			
			// not here, we're in an ordered lower partition of no interest
			lowest = middle + 1; // eliminate it from view
		} else {
			// we are in unordered lower partition
		}
		
		System.out.println("Testing the second partition...");
		if (nums[middle] <= nums[highest]) {
			// the upper partition is ordered
			// are we lucky now?
			if (nums[middle] <= target && nums[highest] >= target) {
				// woot, it's here, at the upper end
				return binarySearch(nums, target, middle, highest);
			}
			
			// didn't happen, we are in an ordered upper partition of no interest
			highest = middle - 1; // eliminate!
		} else {
			// we are in an unordered upper partition
		}
		
		// nothing happened, soooo we need to peruse the unordered partition
		} while (lowest <= highest);
		
		return -1;
	}
	
	private int binarySearch(int[] nums, int target, int lowest, int highest) {
		if (nums.length == 0)
			return -1;
		
		do {
			int middle = (lowest + highest) / 2;
			if (target == nums[middle]) {
				// found it
				return middle;
			}
			if (target > nums[middle]) {
				// it's up the river
				lowest = middle + 1;
			}
			else {
				// it's down, down the river
				highest = middle - 1;
			}
		} while (lowest <= highest);
		
		return -1;
	}
}
