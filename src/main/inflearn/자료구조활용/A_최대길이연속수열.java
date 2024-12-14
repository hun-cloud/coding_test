package main.inflearn.자료구조활용;

import java.util.Arrays;

public class A_최대길이연속수열 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0};
        int solution = solution(nums);
        System.out.println("solution = " + solution);
    }

    public static int solution(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        int currentLength = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                continue;
            }
            if (nums[i+1] - nums[i] == 1) {
                currentLength++;
                result = Math.max(result, currentLength);
                continue;
            }
            currentLength = 1;
        }
        return result;
    }
}
