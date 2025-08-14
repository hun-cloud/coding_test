package main.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {

    // 상하좌우
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        int result = solution(maps);

        System.out.println("result = " + result);
    }

    private static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        // 시작점 (x=0, y=0) 거리 = 1
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            // 도착점 도달
            if (x == n - 1 && y == m - 1) {
                return dist;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 체크 & 벽 X, 미방문
                if (nx >= 0 && ny >= 0 && nx < n && ny < m
                        && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }

        return -1;
    }
}
