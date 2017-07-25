package com.epam.hackerrank;

import java.util.Scanner;

public class MakingAnagrams
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String fStr = sc.nextLine();
        String tStr = sc.nextLine();

        System.out.println(foo(new StringBuilder(fStr), new StringBuilder(tStr)));
    }

    static int foo(StringBuilder one, StringBuilder two) {

        if (one.length() > two.length()) {
            StringBuilder temp = one;
            one = two;
            two = temp;
        }

        int result = 0;

        for (int i = 0; i < one.length();) {
            if (!two.toString().contains("" + one.toString().charAt(i)))
                result += 1;
            else
                two.deleteCharAt(two.indexOf("" + one.toString().charAt(i)));
            one.deleteCharAt(i);
        }

        result += two.length() - one.length();

        return result;
    }
}
