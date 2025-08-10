package main.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 괄호_회전하기 {
    public static void main(String[] args) {

        String s = "}]()[{";

        int result = solution(s);
        System.out.println("result = " + result);
    }

    private static int solution(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();

        Map<Character, Character> charMap = new HashMap<>(){{
            put('}', '{');
            put(')', '(');
            put(']', '[');
        }};

        for (int startIndex = 0; startIndex < charArray.length; startIndex++) {

            if (isCloseChar(charArray[startIndex])) {
                continue;
            }

            int point = startIndex;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < charArray.length; i++) {
                if (point == charArray.length) {
                    point = 0;
                }

                char c = charArray[point];

                if (isCloseChar(c) && stack.isEmpty()) {
                    stack.push(c);
                    break;
                }

                if (isOpenChar(c)) {
                    stack.push(c);
                    point++;
                    continue;
                }

                if (charMap.get(c) == stack.peek()) {
                    stack.pop();
                }

                point++;
            }

            if (stack.isEmpty()) {
                result++;
            }
        }

        return result;
    }

    private static boolean isOpenChar(char c) {
        return c == '[' || c == '(' || c == '{';
    }

    private static boolean isCloseChar(char c) {
        return c == ']' || c == ')' || c == '}';
    }
}
