package main.inflearnbasic.rtg;

import java.util.LinkedList;
import java.util.Queue;

public class 송아지찾기 {

    static int count = 1;
    static boolean[] visited = new boolean[10_001];
    static int[] direction = {1, -1, 5};

    public static void main(String[] args) {

        int myPoint = 5;
        int cowPoint = 14;

        int result = bfs(myPoint, cowPoint);
        System.out.println("result = " + result);
        System.out.println("count = " + count);
    }

    private static int bfs(int myPoint, int cowPoint) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(myPoint);
        visited[myPoint] = true;

        while (!queue.isEmpty()) {
            int m = queue.size();

            for (int i = 0; i < m; i++) {
                int current = queue.poll();

                for (int j = 0; j < direction.length; j++) {
                    int nx = current + direction[j];
                    if (nx == cowPoint) return count;
                    if (nx > 0 && nx <= 10000 && !visited[nx]) {

                        visited[nx] = true;
                        queue.offer(nx);
                    }
                }
            }
            count++;
        }
        return 0;
    }
}
