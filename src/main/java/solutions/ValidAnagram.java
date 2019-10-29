package solutions;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		int[] letters = new int[26];
		for (int i = 0; i < s.length(); i++) {
			letters[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			letters[t.charAt(i) - 'a']--;
		}
		for (int i : letters) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(new ValidAnagram().isAnagram("abcde", "badc"));
	}
}
