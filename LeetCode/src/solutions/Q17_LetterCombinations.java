package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q17_LetterCombinations {
	public List<String> letterCombinations(String digits) {
		String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxzy"};

		ArrayList<String> result = new ArrayList<String>();

		//need an empty string in the original list, so we can append letters to it
		result.add("");

		for (int i = 0; i < digits.length(); i++) {
			result = myAppend(result, letters[digits.charAt(i) - '0']);
		}
		
		return result;
		
		
	}

	public ArrayList<String> myAppend(List<String> oldResult, String letters) {
		ArrayList<String> result = new ArrayList<String>();
		for (String s : oldResult) {
			for (int i = 0; i < letters.length(); i++) {
				result.add(s+letters.charAt(i));
			}
		}
		return result;
	}
	
	//A cool way of solving it
	//The idea is to use a queue, append new letters to  original ones while getting rid of the old ones
	public List<String> letterCombinations2(String digits) {
	    LinkedList<String> ans = new LinkedList<String>();
	    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	    ans.add("");
	    for(int i =0; i<digits.length();i++){
	        int x = Character.getNumericValue(digits.charAt(i));
	        while(ans.peek().length()==i){
	            String t = ans.remove();
	            for(char s : mapping[x].toCharArray())
	                ans.add(t+s);
	        }
	    }
	    return ans;
	}
	

	public static void main(String[] args) {
		Q17_LetterCombinations q = new Q17_LetterCombinations();
		System.out.println(q.letterCombinations("232"));
		
	}
}
