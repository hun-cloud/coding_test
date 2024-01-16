package main.level2;

import java.util.*;

public class 귤_고르기 {

    static class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;
            int total = 0;
            Map<Integer, Integer> map = new HashMap<>();

            for (int i : tangerine) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            List<Integer> list = new ArrayList<>(map.values());
            Collections.sort(list, Comparator.reverseOrder());

            for (int i : list) {
                answer++;
                total += i;
                if (total >= k) {
                    break;
                }
            }

            return answer;
        }
    }
}
