package main.inflearn.해싱시간파싱;

import java.util.HashMap;
import java.util.Map;

public class D_음수가있는부분수열 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3,-3, 1, 2};
        int m = 3;
        int solution = solution(nums, m);
        System.out.println("solution = " + solution);

        int realSolution = realSolution(nums, m);
        System.out.println("realSolution = " + realSolution);
    }

    public static int solution(int[] nums, int m) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == m) result++;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == m) {
                    result++;
                }
            }
        }

        return result;
    }

    public static int realSolution(int[] nums, int m) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum - m == 0) {
                result++;
            }
            if (map.get(sum - m) != null) {
                result += map.get(sum - m);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(map);
        return result;
    }
}
