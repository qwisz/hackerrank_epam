package com.epam.hackerrank;

import java.util.Scanner;

public class Primality {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for (int i = 0; i < p; i++) {
            int n = in.nextInt();
            System.out.println(isPrime(n) ? "Prime" : "Not prime");
        }
    }

    static boolean isPrime(int n) {
        if (n == 1)
            return false;
        if (n == 2)
            return true;

        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
