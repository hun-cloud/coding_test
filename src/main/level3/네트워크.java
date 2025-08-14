package main.level3;

public class 네트워크 {
    public static void main(String[] args) {

        int n = 3;
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
        int result = solution(3, computers);

        System.out.println("result = " + result);
    }

    private static int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int networkCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                networkCount++;
            }
        }

        return networkCount;
    }

    private static void dfs(int node, int[][] computers, boolean[] visited) {
        visited[node] = true;

        for (int i = 0; i < computers.length; i++) {
            if (computers[node][i] == 1 && !visited[i]) {
                dfs(i, computers, visited);
            }
        }
    }
}
