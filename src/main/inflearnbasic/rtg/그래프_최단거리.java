package main.inflearnbasic.rtg;

import java.util.LinkedList;
import java.util.Queue;

public class 그래프_최단거리 {

    static int n, m;
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) {

        n = 5;
        m = 9;
        visited = new boolean[n];

        bfs(1);
    }

    private static int[] bfs(int node) {
        int[] answer = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        int L = 1;
        while (!queue.isEmpty()) {
            int len = graph.length;
            int current = queue.poll();
            for (int i = 1; i <= len; i++) {

                if (graph[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    answer[i] = L;
                    queue.offer(i);
                }
            }
            L++;
        }
        return answer;
    }
}
