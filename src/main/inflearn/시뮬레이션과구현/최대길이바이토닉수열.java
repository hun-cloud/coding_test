package main.inflearn.시뮬레이션과구현;

public class 최대길이바이토닉수열 {
    public static void main(String[] args) {
        int result = solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}); // 8
        System.out.println("result = " + result);
    }

    public static int solution(int[] nums) {
        int maxLength = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            int leftValue = nums[i];
            int leftIndex = i;
            int rightValue = nums[i];
            int rightIndex = i;
            int currentLength = 1;

            while (true) {
                if (leftIndex - 1 < 0 || rightIndex + 1 == nums.length) {
                    break;
                }

                if (leftValue <= nums[leftIndex - 1] && rightValue > nums[rightIndex + 1]) {
                    currentLength += 1;
                    break;
                }

                if (leftValue > nums[leftIndex - 1] && rightValue <= nums[rightIndex + 1]) {
                    currentLength += 1;
                    break;
                }

                leftIndex -= 1;
                rightIndex += 1;
                leftValue = nums[leftIndex];
                rightValue = nums[rightIndex];

                currentLength += 2;
            }
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
