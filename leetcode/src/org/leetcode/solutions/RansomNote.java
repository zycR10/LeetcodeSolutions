package org.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		List<Character> list = new ArrayList<>();
		for (Character c : magazine.toCharArray()) {
			list.add(c);
		}
		int index = 0;
		for (int i = 0; i < ransomNote.length(); i++) {
			if (list.contains(ransomNote.charAt(i))) {
				index = list.indexOf(ransomNote.charAt(i));
				list.remove(index);
				continue;
			}
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String ransomNote = "aa";
		String magazine = "aab";
		System.out.println(new RansomNote().canConstruct(ransomNote, magazine));
	}
}