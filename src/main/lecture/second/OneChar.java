package main.lecture.second;

public class OneChar {
    public static void main(String[] args) {
        int result = solution("abcdeabcdfg");
        System.out.println("result = " + result);
    }

    public static int solution(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            char c = chars[i];
            int count = 0;
            if (c == '0') continue;
            for (int j = i+1; j < chars.length; j++) {
                if (c == chars[j]) {
                    chars[j] = '0';
                    count++;
                }
            }
            if (count == 0) {
                return i+1;
            }
        }

        return -1;
    }
}
