package org.leetcode.solutions;

public class SumTwoIntegers {
	public int getSum(int a, int b) {
		if (b == 0) {
			return a;
		}
		int sum = a ^ b;
		int plus = (a & b) << 1;
		return getSum(sum, plus);
	}
}
