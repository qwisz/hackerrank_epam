package com.epam.hackerrank;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        int f = sc.nextInt();
        int t = sc.nextInt();

        String s;

        for (int i = 0; i < f; i++) {
            s = sc.next();
            if (map.containsKey(s)) {
                int count = map.get(s);
                count += 1;
                map.put(s, count);
            }
            else
                map.put(s, 1);
        }

        String[] array = new String[t];

        for (int i = 0; i < t; i++) {
            array[i] = sc.next();
        }

        System.out.println(isProbably(map, array) ? "Yes" : "No");
    }

    static boolean isProbably(Map<String, Integer> map, String[] array) {

        for (String word : array) {
            if (map.containsKey(word)) {
                int count = map.get(word);

                if (count == 0)
                    return false;

                count--;

                map.put(word, count);
            }
            else
                return false;
        }
        return true;
    }
}
