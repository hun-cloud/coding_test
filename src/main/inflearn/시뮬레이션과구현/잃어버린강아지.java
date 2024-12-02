package main.inflearn.시뮬레이션과구현;

public class 잃어버린강아지 {
    public static void main(String[] args) {
        int[][] board =  {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}
        };

        int solution = solution(board);
        System.out.println("solution = " + solution);
    }

    public static int solution(int[][] board) {
        int result = 0;
        int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int humanDirectionIndex = 0;
        int dogDirectionIndex = 0;
        boolean meetFlag = false;
        int[] humanLocation = findStartLocation(board, 2);
        int[] dogLocation = findStartLocation(board, 3);

        while (!meetFlag) {
            boolean isHumanCanMove = checkCanMove(board, humanLocation, direction, humanDirectionIndex);
            boolean isDogCanMove = checkCanMove(board, dogLocation, direction, dogDirectionIndex);

            if (isHumanCanMove) {
                move(humanLocation, direction, humanDirectionIndex);
            } else {
                humanDirectionIndex = (humanDirectionIndex + 1) % 4;
            }

            if (isDogCanMove) {
                move(dogLocation, direction, dogDirectionIndex);
            } else {
                dogDirectionIndex = (dogDirectionIndex + 1) % 4;
            }

            if (checkSameLocation(humanLocation, dogLocation)) {
                meetFlag = true;
            }

            if (result == 10000) {
                result = 0;
                break;
            }

            result++;
        }

        return result;
    }

    private static void move(int[] location, int[][] direction, int directionIndex) {
        location[0] += direction[directionIndex][0];
        location[1] += direction[directionIndex][1];
    }


    private static boolean checkSameLocation(int[] humanLocation, int[] dogLocation) {
        return humanLocation[0] == dogLocation[0] && humanLocation[1] == dogLocation[1];
    }

    private static boolean checkCanMove(int[][] board, int[] location, int[][] direction, int directionIndex) {
        int[] currentDirection = direction[directionIndex];
        int boardSize = board.length;

        if (location[0] + currentDirection[0] == boardSize || location[1] + currentDirection[1] == boardSize
                || location[0] + currentDirection[0] < 0 || location[1] + currentDirection[1] < 0) {
            return false;
        }

        if (board[location[0] + currentDirection[0]][location[1] + currentDirection[1]] == 1) {
            return false;
        }

        return true;
    }

    private static int[] findStartLocation(int[][] board, int index) {
        int[] location = new int[2];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == index) {
                    location[0] = i;
                    location[1] = j;
                }
            }
        }

        return location;
    }
}
