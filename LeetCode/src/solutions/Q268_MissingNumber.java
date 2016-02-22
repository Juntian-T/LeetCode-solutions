package solutions;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * 
 * For example, 
 * 
 * Given nums = [0, 1, 3] return 2.
 * @author JT
 *
 */

public class Q268_MissingNumber {

	//The algorithm takes O(n) time, and O(n) space.
	//The idea is that use another array to keep track of the occurrence of every element,
	//and find the one that appeared 0 times
	public int missingNumber(int[] nums) {
		int[] occurrence = new int[nums.length+1];
		for (int i = 0; i < nums.length; i++) {
			occurrence[nums[i]] = 1;
		}
		for (int i = 0; i < occurrence.length; i++) {
			if (occurrence[i] == 0) {
				return i;
			}
		}
		return -1;
	}
}
