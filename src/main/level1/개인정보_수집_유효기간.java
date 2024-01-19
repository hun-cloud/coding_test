package main.level1;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class 개인정보_수집_유효기간 {
    public static void main(String[] args) {

        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        Solution solution = new Solution();
        int[] result = solution.solution(today, terms, privacies);
    }

    static class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            List<Integer> result = new ArrayList<>();

            int todayValue = dayValue(today);

            Map<String, Integer> termMap = toMap(terms);

            for (int i = 0; i < privacies.length; i++) {
                String privacy = privacies[i];

                if (checkValid(privacy, todayValue, termMap)) {
                    result.add(i);
                }
            }

            return result.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }

        private boolean checkValid(String privacy, int todayValue, Map<String, Integer> termMap) {
            String[] s = privacy.split(" ");
            int value = dayValue(s[0]);
            int addValue = termMap.get(s[1]);
            return value + addValue - todayValue > 0;
        }

        private Map<String, Integer> toMap(String[] terms) {
            Map<String, Integer> result = new HashMap<>();

            for (String term : terms) {
                String[] s = term.split(" ");
                result.put(s[0], monthValue(s[1]));
            }
            return result;
        }

        private int dayValue(String date) {
            int oneMonthDay = 28;
            String[] dateArrStr = date.split("\\.");

            int[] dateArr = Arrays.stream(dateArrStr)
                    .mapToInt(Integer::valueOf)
                    .toArray();

            return dateArr[2] + dateArr[1] * oneMonthDay + dateArr[0] * oneMonthDay * 12;
        }

        private int monthValue(String month) {
            return Integer.valueOf(month) * 28;
        }
    }
}
