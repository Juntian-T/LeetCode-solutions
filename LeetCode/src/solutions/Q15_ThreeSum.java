package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * 	(-1, 0, 1)
 * 	(-1, -1, 2)
 * 
 * @author JT
 *
 */

public class Q15_ThreeSum {

	//n^2 solution
	public static List<List<Integer>> threeSum3(int[] nums){

		//sort the array so that we can have duplicates next to each other
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length-2; i++) {
			if (i == 0 || nums[i] != nums[i-1]) { //making sure that we start with a unique number (no duplicates)
				
				//two pointers
				int low = i + 1;
				int high = nums.length - 1;

				while (low < high) {
					int sum = nums[i] + nums[low] + nums[high];
					
					if (sum == 0) {
						List<Integer> temp = new ArrayList<Integer>();
						temp.add(nums[i]);
						temp.add(nums[low]);
						temp.add(nums[high]);
						result.add(temp);
						
						//since we found the triple, move both pointers
						high--;
						low++;
						
						//keep moving till the pointer points to a different number, so that we don't have duplicates
						while (low < high && nums[high] == nums [high+1]) {
							high--;
						}
						
						while (low < high && nums[low] == nums [low-1]) {
							low++;
						}
					} else if (sum > 0) { //sum is too large, we need to move down the high pointer
						high--;
					} else { //sum is too small, we need to move up the low pointer
						low++;
					}

				}


			}
		}
		return result;

	}


	//This is better, n^2*logn
	public static List<List<Integer>> threeSum2(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		//HashMap<List<Integer>, Integer> hm = new HashMap<List<Integer>, Integer>();
		Set<List<Integer>> temp = new HashSet<>();
		for (int  i = 0; i < nums.length-2; i++) {
			for (int  j = i+1; j < nums.length-1; j++) {
				int last = 0 - nums[i] - nums[j];
				int indexOfLast = Arrays.binarySearch(nums, j+1, nums.length-1, last);
				if (indexOfLast >= 0) {
					List<Integer> res = new ArrayList<>();
					res.add(nums[i]);
					res.add(nums[j]);
					res.add(last);
					temp.add(res);
				}
			}
		}

		result.addAll(temp);
		return result;
	}



	//this is bad, n^3*nlogn
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		HashMap<List<Integer>, Integer> hm = new HashMap<List<Integer>, Integer>();	

		for (int i = 0; i < nums.length - 2; i++ ) {
			for (int j = i+1; j < nums.length - 1; j++ ) {
				for (int k = j+1; k < nums.length; k++ ) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> resEle = new ArrayList<Integer>();
						int[] temp = new int[3];
						temp[0] = nums[i];
						temp[1] = nums[j];
						temp[2] = nums[k];
						Arrays.sort(temp);
						resEle.add(temp[0]);
						resEle.add(temp[1]);
						resEle.add(temp[2]);
						hm.put(resEle, i);
					}
				}
			}
		}

		for (List<Integer> e : hm.keySet()) {
			result.add(e);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		System.out.println(threeSum3(nums));
	}
}


