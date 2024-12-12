package main.inflearn.해싱시간파싱;

public class D_음수가있는부분수열 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3,-3, 1, 2};
        int m = 3;
        int solution = solution(nums, m);
        System.out.println("solution = " + solution);
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
}
