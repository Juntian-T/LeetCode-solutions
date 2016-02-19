package solutions;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array
 * 
 * @author JT
 *
 */
public class Q169_MajorityElement {

	//This one uses a HashMap, O(n) time, O(n)space
	public int majorityElement(int[] nums) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); 
		int result = -1;
		for (int i: nums) {
			if (!hm.containsKey(i)) {
				hm.put(i, 1);
			} else {
				hm.put(i, hm.get(i) + 1);
				if (hm.get(i) > nums.length / 2) {
					result = i;
					break;
				}
			}
		}
		return result;
	}
	
	//Another approach, O(nlogn) time
	public int majorityElement2(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}

	public static void main(String[] args) {
		int[] test = {1, 2, 3, 4, 2, 2, 2, 2};
		Q169_MajorityElement q = new Q169_MajorityElement();
		System.out.println(q.majorityElement2(test));
	}

}
