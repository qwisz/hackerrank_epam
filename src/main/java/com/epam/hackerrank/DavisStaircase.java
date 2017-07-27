package com.epam.hackerrank;

import java.util.Scanner;

public class DavisStaircase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for (int i = 0; i < s; i++) {
            int n = in.nextInt();
            System.out.println(getNumOfWays(n));
        }
    }

    @Deprecated
    static int getNumberOfWays(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        int result = 0;
        for (int i = 1; i < 4; i++) {
            result += getNumberOfWays(n - i);
        }
        return result;
    }

    static int getNumOfWays(int n) {
        int prevPrev = 1;
        int prev = 2;
        int curr = 4;

        if (n == 1)
            return prevPrev;
        if (n == 2)
            return prev;

        int temp;
        int temp2;
        for (int i = 3; i < n; i++) {
            temp = curr;
            temp2 = prev;
            curr = temp + prev + prevPrev;
            prev = temp;
            prevPrev = temp2;
        }
        return curr;
    }
}
