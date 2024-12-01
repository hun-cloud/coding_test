package main.inflearn.시뮬레이션과구현;

import java.util.Arrays;

public class 청소 {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 1, 0, 1}, {0, 0, 0, 0, 0, 0}, {0, 0,
                0, 0, 0, 1}, {1, 1, 0, 0, 1, 0}, {0, 0, 0, 0, 0,
                0},{0, 0, 0, 0, 0, 0}};
        int k = 20;
        int[] solution = solution(board, k);
        System.out.println(Arrays.toString(solution));

    }

    public static int[] solution(int[][] board, int k) {
        int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int directionIndex = 0;
        int[] result = new int[2];

        for (int i = 0; i < k; i++) {
            boolean isCanMove = checkCanMove(board, result, direction, directionIndex);

            if (isCanMove) {
                move(result, direction, directionIndex);
            } else {
                directionIndex = (directionIndex + 1) % 4;
            }
        }

        return result;
    }

    private static void move(int[] result, int[][] direction, int directionIndex) {
        result[0] += direction[directionIndex][0];
        result[1] += direction[directionIndex][1];
    }

    private static boolean checkCanMove(int[][] board, int[] result, int[][] direction, int directionIndex) {
        int[] moveDirection = direction[directionIndex];
        int boardSize = board.length;

        if (result[0] + moveDirection[0] == boardSize || result[0] + moveDirection[0] < 0
                || result[1] + moveDirection[1] == boardSize || result[1] + moveDirection[1] < 0) {
            return false;
        }

        if (board[result[0] + moveDirection[0]][result[1] + moveDirection[1]] == 1) {
            return false;
        }

        return true;
    }


    public static int[] solutionAnswer(int[][] board, int k) {
        int[] answer = new int[2];
        int n = board.length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, d = 1, count = 0;
        while (count < k) {
            count++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx > n || ny < 0 || ny >= n || board[nx][ny] == 1) {
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
