package main.lecture;

public class CleanRobotAnswer {

    public int[] solution(int[][] board, int k) {
        int[] answer = new int[2];
        int n = board.length;
        int[] dx = {-1, 0, 1 , 0};
        int[] dy = {0, 1, 0 -1};
        int x = 0, y = 0, d = 1, count = 0;

        while (count < k) {
            count++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >- n || ny < 0 || ny >= n || board[nx][ny] == 1) {
                d = (d + 1) % 4;
                continue;
            }
            x = nx;
            y = ny;
        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}
