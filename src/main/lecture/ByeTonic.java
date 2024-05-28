package main.lecture;

public class ByeTonic {
    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 1, 5, 3, 2, 1, 1};
        //int[] nums2 = {1, 1, 2, 3, 5, 7, 4, 3, 1, 2};
        int result = solution(nums);
        System.out.println("result = " + result);
    }

    public static int solution(int[] nums) {
        int result = 0;
        int plusCount = 0;
        int minusCount = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            int nextVal = nums[i+1];
            int nowVal = nums[i];

            if (nextVal - nowVal > 0) {
                if (minusCount > 0) {
                    plusCount = 0;
                    minusCount = 0;
                }
                plusCount++;
            } else if (nextVal - nowVal < 0) {
                if (plusCount != 0){
                    minusCount++;
                }
                if (plusCount > 0 && minusCount <= plusCount) {
                    if (minusCount + plusCount + 1 > result) {
                        result = minusCount + plusCount + 1;
                    }
                }
            } else {
                if (minusCount + plusCount + 1 > result) {
                    result = minusCount + plusCount + 1;
                }
                plusCount = 0;
                minusCount = 0;
            }
        }

        return result;
    }
}
