package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one
 * @author JT
 *
 */
public class Q136_SingleNumber {

	
	//This algorithm uses a set: 
	//If the elements exits already, remove it; otherwise store it
	public int singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i: nums) {
			if (set.contains(i)) {
				set.remove(i);
			} else {
				set.add(i);
			}
		}
		int result = 0;
		for (int i : set){
			result = i;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Q136_SingleNumber q = new Q136_SingleNumber();
		int[] nums = {1, 2, 3, 4, 3, 2, 1,};
		System.out.println(q.singleNumber(nums));

	}

}
