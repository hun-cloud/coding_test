package main.inflearn.시뮬레이션과구현;

public class 최대길이바이토닉수열 {
    public static void main(String[] args) {
        int result = solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}); // 5
        System.out.println("result = " + result);
    }

    public static int solution(int[] nums) {
        int maxLength = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            int currentLength = 1;
            int leftLength = 0;
            int rightLength = 0;
            int leftIndex = i;
            int rightIndex = i;

            while (leftIndex - 1 >= 0 && nums[leftIndex] > nums[leftIndex - 1]) {
                leftLength++;
                leftIndex--;
            }

            while (rightIndex + 1 < nums.length && nums[rightIndex] > nums[rightIndex + 1]) {
                rightLength++;
                rightIndex++;
            }

            if (leftLength > 0 && rightLength > 0) {
                currentLength += (leftLength + rightLength);
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
