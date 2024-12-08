package main.inflearn.해싱시간파싱;

import java.util.HashMap;
import java.util.Map;

public class A_한번사용한최초문자 {
    public static void main(String[] args) {
        int result = solution("abcdeabcdfg");
        System.out.println("result = " + result);
    }

    public static int solution(String s) {
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            int value = charArray[i];
            boolean isUnique = true;
            if (charArray[i] == 0) {
                isUnique = false;
            }

            for (int j = i + 1; j < charArray.length; j++) {
                if (value == charArray[j]) {
                    charArray[j] = 0;
                    isUnique = false;
                }
            }

            if (isUnique) {
                return i + 1;
            }
        }
        return -1;
    }

    public int solutionAnswer(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 1) return i + 1;
        }
        return -1;
    }
}
