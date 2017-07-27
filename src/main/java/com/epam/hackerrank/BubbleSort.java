package com.epam.hackerrank;


import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int res = numOfSwaps(array);

        System.out.println("Array is sorted in " + res + " swaps.");
        System.out.println("First Element: " + array[0]);
        System.out.println("Last Element: " + array[n - 1]);
    }

    static int numOfSwaps(int[] a) {
    int n = a.length;
    int result = 0;
        for (int i = 0; i < n; i++) {
            // Track number of elements swapped during a single array traversal
            int numberOfSwaps = 0;

            int temp;
            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    numberOfSwaps++;
                }
            }
            result += numberOfSwaps;

            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            }
        }
        return result;
    }
}
