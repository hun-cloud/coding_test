package main.level2;

import java.util.HashMap;
import java.util.Map;

public class 의상 {

    public static void main(String[] args) {

        String[][] clothes = {};
        int result = solution(clothes);
    }

    private static int solution(String[][] clothes) {
        int result = 1;

        Map<String, Integer> clothMap = new HashMap<>();

        for (String[] cloth : clothes) {
            clothMap.put(cloth[1], clothMap.getOrDefault(cloth[1], 0) + 1);
        }

        if (clothMap.keySet().size() == 1) {
            return clothMap.get(clothMap.keySet().stream().findFirst().get());
        }

        for (String key : clothMap.keySet()) {
            result = result * (clothMap.get(key) + 1);
        }

        return result - 1;
    }
}
