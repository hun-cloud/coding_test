package main.inflearn.시뮬레이션과구현;

import java.util.Arrays;

public class 사다리타기 {
    public static void main(String[] args) {
        int[][] ladder = {{1, 3, 5}, {1, 3, 6}, {2, 4}};

        char[] solution = solution(7, ladder);
    }

    public static char[] solution(int n, int[][] ladder) {
        int[] resultInt = new int[n];
        char[] result = new char[n];

        for (int i = 0; i < n; i++) {
            resultInt[i] = 65 + i;
        }

        for (int[] line : ladder) {
            for (int value : line) {
                int temp = resultInt[value - 1];
                resultInt[value - 1] = resultInt[value];
                resultInt[value] = temp;
            }
        }

        for (int i = 0; i < resultInt.length; i++) {
            result[i] = (char) resultInt[i];
        }

        return result;
    }
}
