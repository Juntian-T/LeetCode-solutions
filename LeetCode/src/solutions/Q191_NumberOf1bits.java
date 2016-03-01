package solutions;

/**
 * Write a function that takes an unsigned integer and 
 * returns the number of ’1' bits it has (also known as the Hamming weight).
 * @author JT
 *
 */

public class Q191_NumberOf1bits {
	
	//AND every bit of the integer with 1, if the result is 1, then this bit is 1
	//After AND a bit, then right shift the integer, until the integer becomes 0
	public int hammingWeight(int n) {
		int numOfOnes = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				numOfOnes++;
			}
			n = n >>> 1;
		}
		return numOfOnes;
	}
}
