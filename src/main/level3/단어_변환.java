package main.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 단어_변환 {

    public static void main(String[] args) {

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        int result = solution(begin, target, words);
        System.out.println("result = " + result);
    }

    private static int solution(String begin, String target, String[] words) {

        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.offer(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word current = queue.poll();

            if (current.word.equals(target)) {
                return current.count;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canTransform(current.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Word(words[i], current.count + 1));
                }
            }
        }

        return 0;
    }

    // 한 글자만 다른지 확인
    private static boolean canTransform(String current, String word) {
        int diffCount = 0;

        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != word.charAt(i)) {
                diffCount++;
                if (diffCount > 1) return false;
            }
        }

        return diffCount == 1;
    }

    static class Word {
        private String word;
        private int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
