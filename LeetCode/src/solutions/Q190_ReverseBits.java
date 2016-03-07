package solutions;
/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * @author JT
 *
 */

public class Q190_ReverseBits {

	public int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result = result + n & 1; //getting the current bit
			if (i < 31) {
				result = result << 1; //right shift the result, so there is space for next bit, but we only need to shift 31 times
			}
			n = n >>> 1; //right shift the original integer
		}
		return result;
	}
}
