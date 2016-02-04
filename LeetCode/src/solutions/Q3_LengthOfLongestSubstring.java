package solutions;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * @author JT
 * @version August 6, 2015
 */

public class Q3_LengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		
		int res = 0;
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		
		for (int i = 0, j = 0; i < s.length(); ++i) {
			if (hm.containsKey(s.charAt(i))) {
				int newPointer = hm.get(s.charAt(i)) + 1;
				j = newPointer > j ? newPointer : j;
			}
			hm.put(s.charAt(i), i);
			int tempRes = i - j + 1;
			res = tempRes > res ? tempRes : res;
		}
			
		
		return res;
	}
	
	public static void main(String[] args) {
		Q3_LengthOfLongestSubstring sol = new Q3_LengthOfLongestSubstring();
		System.out.println(sol.lengthOfLongestSubstring("abcba"));
	}
}
