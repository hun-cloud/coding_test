package main.inflearn.해싱시간파싱;

import java.io.FileReader;
import java.util.Arrays;

public class B_같은빈도수만들기 {
    public static void main(String[] args) {
        int[] solution = solution("abcdeabc");
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public static int[] solution(String s) {
        char[] charArray = s.toCharArray();
        int[] countArray = new int[5];
        int maxCount = 0;

        for (char c : charArray) {
            countArray[c - 97]++;
            maxCount = Math.max(maxCount, countArray[c - 97]);
        }

        for (int i = 0; i < countArray.length; i++) {
            countArray[i] = maxCount - countArray[i];
        }

        return countArray;
    }
}
