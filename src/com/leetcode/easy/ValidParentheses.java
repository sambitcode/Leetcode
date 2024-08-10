package com.leetcode.easy;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(()("));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;
        else {
            char[] arr = new char[s.length() / 2];
            int arrIndex = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' ||
                        s.charAt(i) == '{' ||
                        s.charAt(i) == '['
                ) {
                    if (arrIndex >= s.length() / 2) {
                        return false;
                    }
                    arr[arrIndex++] = s.charAt(i);
                    //arrIndex++;
                } else {
                    if (arrIndex == 0)
                        return false;
                    arrIndex--;
                    if ((arr[arrIndex] == '(' && s.charAt(i) != ')') ||
                            (arr[arrIndex] == '{' && s.charAt(i) != '}') ||
                            (arr[arrIndex] == '[' && s.charAt(i) != ']')
                    ) {
                        return false;
                    }
                }
            }
            //if all brackets are matching then opening bracket array would come to zero
            return arrIndex == 0;
        }

    }

    //below solution uses stack
    public boolean isValid2(String s) {
        // create a stack to store opening parentheses
        Stack<Character> stack = new Stack<>();

        // loop through the string
        for (int i = 0; i < s.length(); i++) {
            // get the current character
            char c = s.charAt(i);

            // if the current character is an opening parentheses
            if (c == '(' || c == '{' || c == '[') {
                // push it onto the stack
                stack.push(c);
            }
            // if the current character is a closing parentheses
            else if (c == ')' || c == '}' || c == ']') {
                // if the stack is empty, return false
                if (stack.isEmpty()) {
                    return false;
                }
                // pop the top element from the stack
                char top = stack.pop();
                // if the current character and the top element from the stack don't match, return false
                if (c == ')' && top != '(' || c == '}' && top != '{' || c == ']' && top != '[') {
                    return false;
                }
            }
        }
        // if the stack is not empty at the end, return false
        if (!stack.isEmpty()) {
            return false;
        }
        // return true
        return true;
    }

    public static boolean isValid3(String s) {
        while (s.contains("{}") || s.contains("()") || s.contains("[]")) {
            s = s.replace("{}", "");
            s = s.replace("()", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }

}
