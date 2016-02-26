package solutions;


/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 * 
 * @author JT
 *
 */
public class Q35_InsertPosition {

	//O(n) algorithm
	public int searchInsert(int[] nums, int target) {
		int i = 0;
		while (i < nums.length && nums[i] < target) {
			i++;
		}
		return i;
	}
	
	//O(logn) algorithm, using binary search 
	public int searchInsert2(int[] nums, int target) {
		if (target > nums[nums.length-1]) {
			return nums.length;
		}
		if (target < nums[0]) {
			return 0;
		}
		
		int start = 0;
		int end = nums.length-1;
		int mid = (end - start) / 2;
		
		while (target != nums[mid]) {
			if (mid == start) {
				return end;
			}
			if (nums[mid] > target) {
				end = mid;
				mid = (end - start) / 2 + start;
			} else {
				start = mid;
				mid = (end - start) / 2 + start;
			}
		}
		return mid;
	}
}
