package solutions;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to
 * the product of all the elements of nums except nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * @author JT
 *
 */
public class Q238_ProductExceptSelf {

	
	//This algorithm uses two arrays:
	//First array stores the product of all elements up to current element (exclusive)
	//Second array stores the product of all elements after the current element (exclusive)
    public int[] productExceptSelf(int[] nums) {
        int[] res_left = new int[nums.length];
        int[] res_right = new int[nums.length];
        
        res_left[0] = 1;
        res_right[nums.length-1] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            res_left[i] = res_left[i-1] * nums[i-1]; //product up to previous element * value of previous element
        }
        
        for (int i = nums.length-2; i >= 0; i--) { 
        	//remember: if loop from end, the condition are most likely to be i >= 0
            res_right[i] = res_right[i+1] * nums[i+1];
        }
        
        for (int i = 0 ; i < nums.length; i++) {
            res_left[i] = res_left[i] * res_right[i]; 
        }
        
        return res_left;
    }
	
	public static void main(String[] args) {
		Q238_ProductExceptSelf q = new Q238_ProductExceptSelf();
		int[] test = {1, 2, 3, 4, 4};
		for (int i : q.productExceptSelf(test)) {
			System.out.println(i);
		}
	}

}
