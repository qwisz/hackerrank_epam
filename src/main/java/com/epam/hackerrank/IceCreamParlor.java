package com.epam.hackerrank;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IceCreamParlor {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int dollar = in.nextInt();
            int n = in.nextInt();

            int costsArray[] = new int[n];
            for (int j = 0; j < n; j++) {
                costsArray[j] = in.nextInt();
            }
            printCosts(dollar, costsArray);
        }
    }

    static void printCosts(int dollar, int[] costs) {
        int n = costs.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (costs[i] + costs[j] == dollar)
                    System.out.println(++i > ++j ? j + " " + i : i + " " + j);
            }
        }
    }

    static int indexOf(int key, int[] array) {
        int left = 0;
        int right = array.length;

        while (left < right) {
            int middle = (left + right) / 2;
            if (array[middle] < key)
                left = middle + 1;
            else if (array[middle] > key)
                right = middle;
            else
                return middle;

        }
        return -1;
    }
}
