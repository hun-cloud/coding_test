package main.temp;

import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {
        int[][] score = {{100, 800, 900, 1000}, {900, 200, 300, 500},{500, 600, 120, 800}};

        solution(score);
    }

    public static int[] solution(int[][] score) {
        int[] answer = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            int min = 1001, max = 0, sum = 0;

            for (int item : score[i]) {
                if (min > item) {
                    min = item;
                }
                if (max < item) {
                    max = item;
                }
            }

            for (int item : score[i]) {
                if (item != min && item != max) {
                    sum += item;
                }
            }

            answer[i] = grade(sum / (score[i].length - 2));
        }
        return answer;
    }

    private static int grade(int avgScore) {
        boolean plusGrade = avgScore % 100 == 0;
        avgScore /= 100;

        int result =  switch (avgScore) {
            case 9 -> 1;
            case 8 -> 2;
            case 7 -> 3;
            case 6 -> 4;
            case 5 -> 5;
            case 4 -> 6;
            case 3 -> 7;
            case 2 -> 8;
            default -> 9;
        };

        if (plusGrade && result != 1) {
            result++;
        }

        return result;
    }
}
