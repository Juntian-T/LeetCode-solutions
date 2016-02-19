package solutions;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 *  A -> 1
 *  B -> 2
 *  C -> 3
 *  ...
 *  Z -> 26
 *  AA -> 27
 *  AB -> 28 
 * 
 * @author JT
 *
 */

public class Q171_ExcelSheetColumnNumber {

	//When in need of previous calculated values, other than DP, try things like result = result * x + y
	public int titleToNumber(String s) {
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			result = result * 26 + s.charAt(i) - 64;
		}
		return result;
	}

	public static void main(String[] args) {


	}

}