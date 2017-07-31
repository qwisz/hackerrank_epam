package sort;

import java.util.Scanner;

public class CountingInversions {

    public static void main(String[] args) {

        Merge merge = new Merge();

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int arr[] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }
            System.out.println(merge.countingInvertions(arr));
        }
    }
}
