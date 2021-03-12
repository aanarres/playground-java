package xyz.anarres.algos;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * 
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 * 

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Input: nums = [], target = 0
Output: [-1,-1]

 *
 */
public class FirstLastPosition {

	public static void main(String[] args) {
		// tests
		FirstLastPosition pos = new FirstLastPosition();
		int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		System.out.println("For " + Arrays.toString(nums) + " target=" + target + ", range is: " + Arrays.toString(pos.searchRange(nums, target)));
		
		nums = new int[] {5,7,8,8,10};
		target = 6;
		System.out.println("For " + Arrays.toString(nums) + " target=" + target + ", range is: " + Arrays.toString(pos.searchRange(nums, target)));
		
		nums = new int[] {};
		target = 0;
		System.out.println("For " + Arrays.toString(nums) + " target=" + target + ", range is: " + Arrays.toString(pos.searchRange(nums, target)));
		
	}

	public int[] searchRange(int[] nums, int target) {
		int[] defaultPosition = new int[] { -1, -1 };
		if (nums == null && nums.length == 0)
			return defaultPosition;
		
		// find some position; they're nicely ordered
		int position = search (nums, target, 0, nums.length - 1);
		if (position == -1)
			return defaultPosition;
		
		// how much left from here, and how much right from here
		int i = position;
		while (nums[i] == target) {
			defaultPosition[0] = i;
			if (i == 0)
				break;
			i--;
		}
		i = position;
		while (nums[i] == target) {
			defaultPosition[1] = i;
			if (i == nums.length - 1)
				break;
			i++;
		}
		return defaultPosition;

	}
	private int search(int[] nums, int target, int lowIndex, int highIndex) {
		if (nums.length == 0)
			return -1;
		
		if (lowIndex > highIndex || lowIndex == -1 || highIndex == nums.length)
			return -1;
		
		if (nums[lowIndex] == target)
			return lowIndex;
		if (nums[highIndex] == target)
			return highIndex;
		
		int middle = (lowIndex + highIndex) / 2;
		
		if (nums[middle] == target)
			return middle;
		
		if (lowIndex >= highIndex)
			return -1;
		
		if (nums[middle] > target) {
			// it's downstream, never up from here
			return search(nums, target, lowIndex, middle - 1);
		}
		
		if (nums[middle] < target) {
			// it's upstream, not down from here
			return search(nums, target, middle + 1, highIndex);
		}
		return -1;
	}

}
