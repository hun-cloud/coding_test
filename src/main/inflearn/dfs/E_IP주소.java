package main.inflearn.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class E_IP주소 {
    static LinkedList<String> tmp;
    static ArrayList<String> res;
    public static void main(String[] args) {
        String s = "2025505";
        String[] result = solution(s);
        System.out.println(Arrays.toString(result));
    }

    public static String[] solution(String s) {
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        dfs(0, s);
        String[] answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }

    public static void dfs(int start, String s) {
        if (tmp.size() == 4 && start == s.length()) {
            String Ts = "";
            for (String x : tmp) {
                Ts += x + ".";
            }
            res.add(Ts.substring(0, Ts.length() - 1));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (s.charAt(start) == '0' && i > start) {
                    return;
                }
                String num = s.substring(start, i + 1);
                if (Integer.valueOf(num) > 255) {
                    return;
                }
                tmp.add(num);
                dfs(i + 1, s);
                tmp.pollLast();
            }
        }
    }
}
