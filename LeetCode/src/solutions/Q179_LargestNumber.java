package solutions;

public class Q179_LargestNumber {

	public String largestNumber(int[] nums) {
		StringBuilder result = new StringBuilder("");
		if (nums.length == 0) return result.toString();

		for (int i = 0; i < nums.length - 1; i++) {
			String num1 = Integer.toString(nums[i]);
			for (int j = i + 1; j < nums.length; j++) {
				String num2 = Integer.toString(nums[j]);
				if ((num2+num1).compareTo(num1+num2) > 0) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
					num1 = Integer.toString(nums[i]);
				}		
			}
		}   
		for (int i = 0; i < nums.length; i++) {
			result.append(Integer.toString(nums[i]));
		}

		return result.toString();
	}


	public static void main(String[] args) {
		Q179_LargestNumber q = new Q179_LargestNumber();
		int[] nums = {3, 30, 34, 5, 9};
		System.out.println(q.largestNumber(nums));

	}

}
