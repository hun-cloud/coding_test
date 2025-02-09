package main.inflearn.greedy;

import java.util.Arrays;

public class B_이동_횟수 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5};
        int result = solution(nums);
        System.out.println("result = " + result);
    }

    public static int solution(int[] nums) {
        int result = 0;

        Arrays.sort(nums);

        for (int start = 0, end = nums.length-1; start <= end ;) {

            if (nums[start] + nums[end] <= 5) {
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
