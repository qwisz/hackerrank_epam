package com.epam.hackerrank;

import com.epam.hackerrank.heap.Heap;
import com.epam.hackerrank.heap.MaxHeap;
import com.epam.hackerrank.heap.MinHeap;
import java.util.Scanner;

public class FindTheRunningMedian {

    static Heap maxHeap = new MaxHeap();
    static Heap minHeap = new MinHeap();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int firstElement = a[0];
        int secondElement = a[1];

        System.out.println((double) firstElement);
        System.out.println((firstElement + secondElement) / 2.0);

        if (firstElement > secondElement) {
            minHeap.add(firstElement);
            maxHeap.add(secondElement);
        } else {
            minHeap.add(secondElement);
            maxHeap.add(firstElement);
        }

        double result;
        for (int i = 2; i < n; i++) {

            if (a[i] > maxHeap.peek()) {
                minHeap.add(a[i]);
            }
            else
                maxHeap.add(a[i]);

            checkBalance();

            System.out.println(median());
        }
    }

    private static double median() {
        double answer;
        if (maxHeap.getSize() == minHeap.getSize()) {
            answer = (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        else if (maxHeap.getSize() > minHeap.getSize())
            answer = maxHeap.peek();
        else
            answer = minHeap.peek();

        return answer;
    }

    private static void checkBalance() {
        if (maxHeap.getSize() - minHeap.getSize() > 1)
            changeMinHeap();
        if (minHeap.getSize() - maxHeap.getSize() > 1)
            changeMaxHeap();
    }

    private static void changeMaxHeap() {
        int root = minHeap.poll();
        maxHeap.add(root);
    }
    private static void changeMinHeap() {
        int root = maxHeap.poll();
        minHeap.add(root);
    }
}
