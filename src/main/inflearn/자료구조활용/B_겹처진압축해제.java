package main.inflearn.자료구조활용;

import java.util.Stack;
import java.util.stream.Collectors;

public class B_겹처진압축해제 {
    public static void main(String[] args) {
        String solution = solution("3(a2(b))ef");
        System.out.println("solution = " + solution);
    }

    public static String solution(String s) {
        char[] charArray = s.toCharArray();
        Stack<String> st = new Stack<>();

        for (Character c : charArray) {
            if (c == ')') {
                String tmp = "";
                while (!st.isEmpty()) {
                    String p = st.pop();
                    if (p.equals("(")) {
                        if (!st.isEmpty() && Character.isDigit(st.peek().charAt(0))) {
                            int num = Integer.parseInt(st.pop());
                            st.push(tmp.repeat(num));
                            break;
                        }
                        st.push(tmp);
                    }
                    tmp = p + tmp;
                }
            } else {
                st.push(String.valueOf(c));
            }

        }
        
        return st.stream().collect(Collectors.joining());
    }
}
