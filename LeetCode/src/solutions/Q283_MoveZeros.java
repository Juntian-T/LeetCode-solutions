package solutions;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order
 * of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, 
 * nums should be [1, 3, 12, 0, 0].
 * 
 * @author JT
 *
 */
public class Q283_MoveZeros {

	//This algorithm uses a helper method that puts the zeros to the end
	//However, it doesn't work when there are consecutive zeros. So abandon it
	public void moveZeroes(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				putToEnd(i, nums);
			}
		}
	}

	private void putToEnd(int index, int[] nums) {
		for (int i = index; i < nums.length - 1; i++) {
			nums[i] = nums[i+1];
		}
		nums[nums.length-1] = 0;

	}
	
	//Move all the non-zero integer to the front, and fill the rest with zeros
	public void moveZeroes2(int[] nums) {
		int insert = 0;
		for (int i : nums) {
			if (i != 0) {
				nums[insert++] = i;
			}
		}
		
		while (insert < nums.length) {
			nums[insert] = 0;
			insert++;
		}
		
	}

	public static void main(String[] args) {
		Q283_MoveZeros q = new Q283_MoveZeros();
		int[] test = {0, 0, 1};
		q.moveZeroes2(test);
		for (int i : test) {
			System.out.println(i);
		}

	}

}