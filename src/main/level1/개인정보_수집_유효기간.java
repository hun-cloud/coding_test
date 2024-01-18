package main.level1;

import java.util.Arrays;

public class 개인정보_수집_유효기간 {
    public static void main(String[] args) {

        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};


        Solution solution = new Solution();
        solution.solution(today, terms, privacies);
    }
    static class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            int[] answer = {};
            int[] todayArr = Arrays.stream(today.split(".")).mapToInt(Integer::parseInt).toArray();
            System.out.println("todayArr = " + Arrays.toString(todayArr));
            return answer;
        }
    }
}
