package solutions;

/**
 *  There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. 
 *	On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on).
 *  For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 *  
 *  @author JT
 *
 */
public class Q319_BulbSwitcher {


	//The idea comes from LeetCode discussion.
	//The bulb is on iff it's been switched odd number of times;
	//Therefore, if it's a prime number -> off (switched twice)
	//If a number has divisors other than 1 and itself, is comes with pairs (eg. 2 and 3 for 6), and it means even number of switches
	//However, if this number is a square number, it has its square root as a divisor, and its mean odd number of switches
	//Therefore, we just need to find all the square numbers
	
	//But how do we know how many squares we have up to n?
	//Lets say r = (int) sqrt(n), then r is the largest square root from 1 to n, and there are also r number of 
	//square roots in the range from 1 to n.
	public int bulbSwitch(int n) {
		return (int) Math.sqrt(n);
	}

}
