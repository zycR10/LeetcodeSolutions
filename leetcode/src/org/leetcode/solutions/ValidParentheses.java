package org.leetcode.solutions;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		// when the character is ')' or '}' or ']'
		// only way to match left symbol is that the previous is '(' or '{' or '['
		// so it's just like stack, last in first out
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(new ValidParentheses().isValid("({])"));
	}
}
