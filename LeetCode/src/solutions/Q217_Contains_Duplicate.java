package solutions;

import java.util.HashSet;

/**
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct. 
 * 
 * @author JT
 *
 */

public class Q217_Contains_Duplicate {

	//Pretty straight-forward, use a hash set.
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i: nums) {
			if (set.contains(i)) {
				return true;
			} else {
				set.add(i);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Q217_Contains_Duplicate q = new Q217_Contains_Duplicate();
		int[] nums = {1, 2, 3, 4, 5, 1};
		System.out.println(q.containsDuplicate(nums));

	}

}
