package com.epam.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LonelyInteger {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        List<Integer> list = new ArrayList<Integer>();

        for (int num : a) {
            if (list.contains(num))
                list.remove((Integer) num);
            else
                list.add(num);
        }

        System.out.println(list.get(0));
    }
}
