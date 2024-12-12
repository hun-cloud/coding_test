package main.inflearn.해싱시간파싱;

import java.lang.reflect.Array;
import java.util.*;

public class C_서로다른빈도수만들기 {
    public static void main(String[] args) {
        String s = "aaabbbcccdddeeeeeff";
        int solution = solution(s);
        System.out.println("solution = " + solution);
    }

    public static int solution(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        Map<Character, Integer> cMap = new HashMap<>();
        int max = 0;

        for (char c : charArray) {
            cMap.put(c, cMap.getOrDefault(c, 0) + 1);
            max = Math.max(max, cMap.get(c));
        }

        int[] countArray = cMap.values().stream().mapToInt(i -> i)
                .toArray();

        Arrays.sort(countArray);

        for (int i = countArray.length - 1; i > 0; i--) {
            if (countArray[i] <= countArray[i - 1]) {
                while (countArray[i] <= countArray[i - 1] && countArray[i - 1] != 0) {
                    countArray[i - 1]--;
                    result++;
                }
            }
        }

        return result;
    }
}
