package solutions;

import java.util.HashSet;

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words 
 * do not share common letters. 
 * 
 * 
 * You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 * 
 * @author JT
 *
 */
public class Q318_MaximumProductofWordLengths {

	
	//This is the brute force version. 
    public int maxProduct(String[] words) {
    	int result = 0;
        for (int i = 0; i < words.length - 1; i++) {
        	for (int j = 1; j < words.length; j++) {
        		if (!shareCommonLetters(words[i], words[j])) {
        			result = Math.max(result, words[i].length() * words[j].length());
        		}
        	}
        }
        return result;
    }
	
	private boolean shareCommonLetters(String s1, String s2) {
		HashSet<Character> hs = new HashSet<Character>();
		for (int i = 0; i < s1.length(); i++) {
			hs.add(s1.charAt(i));
		}
		for (int i = 0; i < s2.length(); i++) {
			if (hs.contains(s2.charAt(i))) return true;
		}
		return false;
	}
	
}
