package main.again;

import java.util.*;

public class 귤고르기 {
    public static void main(String[] args) {

        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        int result = solution(k, tangerine);
    }

    private static int solution(int k, int[] tangerine) {
        int result = 0;
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> values = new ArrayList<>(map.values());
        values.sort(Comparator.reverseOrder());

        for (int i : values) {
            result++;
            total += i;
            if (total >= k) {
                break;
            }
        }
        return result;
    }
}
