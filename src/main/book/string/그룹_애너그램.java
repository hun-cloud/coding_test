package main.book.string;

import java.util.*;

public class 그룹_애너그램 {
    public static void main(String[] args) {

    }
    /*
    문자열 배열으 받아 애너그램 단위로 그룹핑하라
    * in : ["eat", "tea", "tan", "ate", "ant", "cat"]
    * out : {["eat", "tea", "ant"], ["tan", "ant"], ["cat"]}
    * */

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> results = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();

            Arrays.sort(chars);

            String key = String.valueOf(chars);

            if (!results.containsKey(key)) {
                results.put(key, new ArrayList<>());
            }
            results.get(key).add(str);
        }

        return new ArrayList<>(results.values());
    }
}
