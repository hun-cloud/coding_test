package main.lecture.second;

import java.util.Arrays;
import java.util.OptionalInt;

public class SameBindo {
    public static void main(String[] args) {
        solution("abbccddee");
    }

    public static int[] solution(String s) {
        int[] ints = new int[5];

        char[] chars = s.toCharArray();

        for (char c : chars) {
            ints[(int)c - 97] += 1;
        }

        int max = 0;
        for (int i : ints) {
            if (max < i) {
                max = i;
            }
        }

        for (int i = 0; i < ints.length; i++) {
            ints[i] = max - ints[i];
        }

        return ints;
    }
}
