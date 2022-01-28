package com.sxg.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author sxg
 * create in 2022/1/27
 */
public class ValidParentheses {

    public static void main(String[] args) {
        boolean res = solution("{}]");
        System.out.println(res);
    }

    private static boolean solution(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        int length = str.length();
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || pairs.get(ch) != stack.peek()) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
