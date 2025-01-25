package main.inflearn.greedy;

import java.util.Arrays;

public class A_침몰하는_타이타닉 {

    public static void main(String[] args) {
        int[] nums = {90, 50, 70, 100, 60, 80};
        int result = solution(nums, 140);
        System.out.println("result = " + result);
    }

    public static int solution(int[] nums, int m) {
        int result = 0;

        Arrays.sort(nums);
        for (int start = 0, end = nums.length -1; start <= end ; ) {

            if (nums[start] + nums[end] <= m) {
                result++;
                start++;
                end--;
                continue;
            }

            result++;
            end--;
        }

        return result;
    }
}
