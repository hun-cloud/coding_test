package main.lecture;

import java.util.Arrays;

public class FindDog {
    public static void main(String[] args) {

        int[][] board = {
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};

        int[][] board2 = {
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};

        int result = solution(board);
        System.out.println("result = " + result);
    }

    public static int solution(int[][] board) {
        int[] man = new int[2];
        int[] dog = new int[2];
        int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int manD = 0, dogD = 0;

        for (int i = 0, find = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 2) {
                    man[0] = i;
                    man[1] = j;
                    find++;
                } else if (board[i][j] == 3) {
                    dog[0] = i;
                    dog[1] = j;
                    find++;
                }
            }
            if (find == 2) break;
        }

        for (int i = 1; i <= 10_000; i++) {
            manD = (manD + move(board, direction, man, manD)) % 4;
            dogD = (dogD + move(board, direction, dog, dogD)) % 4;

            if (man[0] == dog[0] && man[1] == dog[1]) {
                return i;
            }
        }

        return 0;
    }

    private static int move(int[][] board, int[][] direction, int[] location, int directionNum) {
        int x = location[0];
        int y = location[1];

        if (x + direction[directionNum][0] < 0 || y + direction[directionNum][1] < 0 ||
                x + direction[directionNum][0] == board.length || y + direction[directionNum][1] == board.length ||
                board[x + direction[directionNum][0]][y + direction[directionNum][1]] == 1
        ) {
            return 1;
        } else {
            location[0] += direction[directionNum][0];
            location[1] += direction[directionNum][1];
        }
        return 0;
    }
}
