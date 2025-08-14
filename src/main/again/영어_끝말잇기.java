package main.again;

import java.util.ArrayList;
import java.util.List;

public class 영어_끝말잇기 {
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        int[] result = solution(n, words);
    }

    private static int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0) || list.contains(words[i])) {
                return new int[]{i % n + 1, i / n + 1};
            }
            list.add(words[i]);
        }
        return new int[]{0, 0};
    }
}
