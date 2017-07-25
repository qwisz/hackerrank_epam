package com.epam.hackerrank;


import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            System.out.println(isBalanced(s) ? "YES" : "NO");
        }
    }

    static boolean isBalanced(String s) {

        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(': {
                    brackets.push(c);
                    break;
                }
                case '{': {
                    brackets.push(c);
                    break;
                }
                case '[': {
                    brackets.push(c);
                    break;
                }
                case ')': {
                    if (brackets.size() == 0 || brackets.pop() != '(')
                        return false;
                    break;
                }
                case '}': {
                    if (brackets.size() == 0 || brackets.pop() != '{')
                        return false;
                    break;
                }
                case ']': {
                    if (brackets.size() == 0 || brackets.pop() != '[')
                        return false;
                    break;
                }
            }
        }
        return brackets.size() != 0;
    }
}
