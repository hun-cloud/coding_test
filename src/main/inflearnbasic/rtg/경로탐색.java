package main.inflearnbasic.rtg;

public class 경로탐색 {
    static int n, m, answer = 0;
    static int[][] graph;
    static boolean[] visited;

    public void dfs(int v) {
        if (v==n) answer++;
        else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    dfs(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5; // 노드 개수
        int m = 9; // 간선 개수

        graph = new int[n + 1][m + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {

        }

    }
}
