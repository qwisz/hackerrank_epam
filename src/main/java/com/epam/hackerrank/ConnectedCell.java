package com.epam.hackerrank;

import java.util.Scanner;

public class ConnectedCell {

    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] matrice = new int[m][n];
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                matrice[i][j] = scan.nextInt();
                visited[i][j] = false;
            }
        }
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j])
                    max = Math.max(max, countCell(matrice, i, j, m, n));
            }
        }
        System.out.println(max);
    }

    static int countCell(int[][] matrice, int i, int j, int m, int n) {
        if(i < 0 || j < 0 || i >= m || j >= n)
            return 0;
        if(visited[i][j])
            return 0;
        visited[i][j] = true;
        if(matrice[i][j] == 0)
            return 0;
        else return 1 +
                countCell(matrice, i-1, j-1, m, n) +
                countCell(matrice, i-1, j, m, n) +
                countCell(matrice, i-1, j+1, m, n) +
                countCell(matrice, i, j-1, m, n) +
                countCell(matrice, i, j, m, n) +
                countCell(matrice, i, j+1, m, n) +
                countCell(matrice, i+1, j-1, m, n) +
                countCell(matrice, i+1, j, m, n) +
                countCell(matrice, i+1, j+1, m, n);
    }
}
