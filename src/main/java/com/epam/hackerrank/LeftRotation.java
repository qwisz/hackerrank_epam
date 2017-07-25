package com.epam.hackerrank;

import java.util.Scanner;

public class LeftRotation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        arr = rotate(arr, n, d);

        for (int i: arr) {
            System.out.print(i + " ");
        }
    }

    static int[] rotate(int[] array, int n, int d) {

        int[] arr = new int[n];

        System.arraycopy(array, d - n + n - d, arr, n - d, n - (n - d));
        System.arraycopy(array, d, arr, 0, n - d);

        return arr;
    }
}
