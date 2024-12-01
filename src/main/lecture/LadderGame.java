package main.lecture;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderGame {

    public static void main(String[] args) {
        int n = 5;
        int[][] ladderInfo = {{1,3}, {2,4}, {1,4}};
        char[] answer = solution(n, ladderInfo);
        System.out.println("answer = " + answer);
    }

    public static char[] solution(int n, int[][] ladders) {
        char[] result = new char[n];

        for (int i = 0; i < n; i++) {
            result[i] = (char)(i + 65);
        }

        for (int[] line : ladders) {
            for (int value : line) {
                char temp = result[value-1];
                result[value-1] = result[value];
                result[value] = temp;
            }
        }

        return result;
    }
}
