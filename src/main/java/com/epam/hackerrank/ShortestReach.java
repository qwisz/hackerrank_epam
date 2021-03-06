package com.epam.hackerrank;


import java.util.*;

public class ShortestReach {

    public static class Graph {

        private List<List<Integer>> matrice;
        private int size;

        public Graph(int size) {
            this.size = size;
            matrice = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                matrice.add(new ArrayList<>());
            }
        }

        public void addEdge(int first, int second) {
            matrice.get(first).add(second);
            matrice.get(second).add(first);
        }

        public int[] shortestReach(int startId) {
            LinkedList<Integer> list = new LinkedList<>();

            int[] distances = new int[size];
            Arrays.fill(distances, -1);

            distances[startId] = 0;
            list.add(startId);

            HashSet<Integer> visited = new HashSet<>();
            visited.add(startId);

            while (!list.isEmpty()) {
                int current = list.poll();
                for (int node : matrice.get(current)) {
                    if (!visited.contains(node)) {
                        list.offer(node);
                        visited.add(node);
                        distances[node] = distances[current] + 6;
                    }
                }
            }
            return distances;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
