package main.inflearn.greedy;

import java.util.Arrays;

public class B_이동횟수 {

    public static void main(String[] args) {
        int[] nums = {2, 5, 3, 4, 2, 3};
        int result = solution(nums);
        System.out.println("result = " + result);
    }

    public static int solution(int[] nums) {
        int result = 0;
        Arrays.sort(nums);

        for (int start = 0, end = nums.length - 1; start <= end ;) {

            if (nums[end] + nums[start] <= 5) {
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
