package solutions;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public class LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty())
            return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        // result length is the length of digits
        for (int i = 0; i < digits.length(); i++) {
            // get every character
            int x = Character.getNumericValue(digits.charAt(i));
            // when ans.peek().length() == i means there are still some String
            // don't combine with other character on 'next number'.
            while (ans.peek().length() == i) {
                // remove origin string
                // append character on next num
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        new LetterCombinationsPhoneNumber().letterCombinations("67");
    }
}
