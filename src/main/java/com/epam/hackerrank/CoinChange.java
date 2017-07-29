package com.epam.hackerrank;


import java.util.Scanner;

public class CoinChange {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for (int i = 0; i < m; i++) {
            coins[i] = in.nextInt();
        }

        System.out.println(change(coins, n));
    }

    static long change(int[] coins, int dollar) {
        long[] result = new long[dollar + 1];
        result[0] = 1L;
        for (int coin : coins) {
            for (int j = coin; j < result.length; j++) {
                result[j] += result[j - coin];
            }
        }
        return result[dollar];
    }
}
