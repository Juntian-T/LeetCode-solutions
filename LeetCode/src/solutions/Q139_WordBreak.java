package solutions;

import java.util.HashSet;
import java.util.Set;

public class Q139_WordBreak {

	public boolean wordBreak(String s, Set<String> wordDict) {

		if (s.length() == 0) {
			return true;
		}

		for (int i = 0; i <= s.length(); i++) {
			if (wordDict.contains(s.substring(0, i)) && wordBreak(s.substring(i, s.length()), wordDict)) {

				return true;
			}
		}
		return false;
	}

	public boolean wordBreak2(String s, Set<String> wordDict) {
		boolean[] t = new boolean[s.length()+1];

		t[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (t[j] == true &&  wordDict.contains(s.substring(j, i))) {
					t[i] = true;
					break;
				}
			}
		}	
		return t[s.length()];
	}

	public static void main(String[] args) {
		Q139_WordBreak q = new Q139_WordBreak();
		Set<String> s = new HashSet<String>();
		s.add("leet");
		s.add("code");
		s.add("apple");
		System.out.println(q.wordBreak2("leetapple", s));
	}
}
