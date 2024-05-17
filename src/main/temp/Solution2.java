package main.temp;

public class Solution2 {
    public static void main(String[] args) {
        solution(new int[]{5, 2, 3, -1, 1, 5});
    }

    public static int solution(int[] foods) {
        int result = 0, foodSum = 0;

        if (foods.length < 3) {
            return result;
        }

        for (int food : foods) {
            foodSum += food;
        }

        int firstValue = 0;
        for (int i = 0; i < foods.length - 2; i++) {
            firstValue += foods[i];
            int middleValue = 0;
            for (int j = i + 1; j < foods.length -1; j++) {
                middleValue += foods[j];
                if (firstValue == middleValue && middleValue == (foodSum - firstValue - middleValue)) {
                    result++;
                }
            }

        }
        return result;
    }
}
