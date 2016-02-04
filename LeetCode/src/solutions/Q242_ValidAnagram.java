package solutions;

public class Q242_ValidAnagram {

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;
		if (s.length() == 0 && t.length() == 0) return true;

		int[] word1 = new int[128];
		int[] word2 = new int[128];

		for (int i = 0; i < s.length(); i++) {
			word1[s.charAt(i)]++;
			word2[t.charAt(i)]++;
		}

		for (int i = 0; i < 128; i++) {
			if (word1[i] != word2[i]) return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Q242_ValidAnagram q = new Q242_ValidAnagram();
		System.out.println(q.isAnagram("anagram", "nagaram"));

	}

}
