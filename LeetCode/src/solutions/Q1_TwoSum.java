package solutions;

import java.util.HashMap;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
 * @author JT
 * @version May 28, 2015
 */
public class Q1_TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		int firstIndex = 0;
		int secondIndex = 0;
		int[] result = new int[2];

		for (int i = 0; i < nums.length; i++) {
			if (hm.containsKey(nums[i])) {
				if (nums[i] * 2 == target) {
					firstIndex = hm.get(nums[i]) + 1;
					secondIndex = i + 1;
					result[0] = firstIndex;
	                result[1] = secondIndex;
					return result;
				}
			} else {
				hm.put(nums[i], i);
			}
		}

		for (int i = 0; i < nums.length; i++) {
			int second = target - nums[i];
			if (hm.containsKey(second) && hm.get(second) < i) {
				secondIndex = i + 1;
				firstIndex = hm.get(second) + 1;
			}
		}
		
		result[0] = firstIndex;
		result[1] = secondIndex;
		return result;
	}
}
