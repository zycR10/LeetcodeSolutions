package solutions;

import java.util.ArrayList;
import java.util.List;

public class NumberComplement {
	class Solution {
		public int findComplement(int num) {
			List<Integer> list = new ArrayList<Integer>();
			do {
				list.add(num % 2);
				num /= 2;
			} while (num > 0);
			int multipar = 1;
			int result = 0;
			for (int n : list) {
				if (n == 1) {
					result += 0 * multipar;
					multipar *= 2;
				} else {
					result += 1 * multipar;
					multipar *= 2;
				}
			}
			return result;
		}
	}

}
