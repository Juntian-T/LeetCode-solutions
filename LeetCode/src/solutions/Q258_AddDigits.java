package solutions;

public class Q258_AddDigits {

	//O(n) operation 
	public int addDigits(int num) {
		while (num >= 10) {
			String digit = num + ""; //make it a string
			char[] digits = digit.toCharArray();
			num = 0;
			for (char c : digits) {
				num+= c - '0';
			}
		}
		return num;
	}
	
	//This idea comes from the hint:
	//the result could only be between 1 and 9 (inclusive)
	//and it comes up periodically
	public int addDigits2(int num) {
		return num % 9 == 0 ? 9 : num % 9;
	}

	public static void main(String[] args) {
		Q258_AddDigits q = new Q258_AddDigits();
		System.out.println(q.addDigits2(108));
	}

}
