package com.epam.hackerrank;

import java.util.Scanner;

public class FibonacciNumbers {

    static int fibonacci(int n) {

        int prev = 0;
        int curr = 1;

        for (int i = 1; i < n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }

        return curr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
