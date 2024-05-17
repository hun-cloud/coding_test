package main.lecture;

import java.util.Arrays;

public class CleanRobot {
    public static void main(String[] args) {
//        int [][] board = {{0, 0, 0, 0, 0},
//                {0, 1, 1, 0, 0},
//        {0, 0, 0, 0, 0}, {1, 0, 1, 0, 1},
//        {0, 0, 0, 0, 0}};

        int[][] board = {{0, 0, 0, 1, 0, 1},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1},
                        {1, 1, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0}};
        int k = 20;

        // int k = 10;
        solution(board, k);
    }



    public static int[] solution(int[][] board, int k) {

        int [] answer = {0, 0};
        int[][] direction = {{0, 1}, {1, 0}, {0,-1}, {-1, 0}};
        int directionNum = 0;

        for (int i = 0; i < k; i++) {
            int x = direction[directionNum][1];
            int y = direction[directionNum][0];

            if (
                    answer[1] + x < 0 ||
                    answer[0] + y < 0 ||
                    answer[1] + x >= board.length ||
                    answer[0] + y >= board.length ||
                    board[answer[0] + y][answer[1] + x] == 1
            ) {
                directionNum++;
                directionNum %= 4;
                continue;
            }

            answer[0] += y;
            answer[1] += x;

        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
