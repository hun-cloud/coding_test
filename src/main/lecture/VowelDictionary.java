package main.lecture;

import java.util.ArrayList;
import java.util.List;

public class VowelDictionary {

    public static String[] words = {"A", "E", "I", "O", "U"};
    public static List<String> list;
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        dfs("", 0);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public void dfs(String word, int length) {
        list.add(word);
        if (length == 5) return;
        for (int i = 0; i < 5; i++) {
            dfs(word + words[i], length+1);
        }
    }
}
