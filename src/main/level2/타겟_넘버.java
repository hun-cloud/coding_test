package main.level2;

public class 타겟_넘버 {

    static int count = 0;

    public static void main(String[] args) {

        int[] numbers = {1,1,1,1,1};
        int target = 3;

        int result = solution(numbers, target);

        System.out.println("result = " + result);
    }

    private static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return count;
    }

    private static void dfs(int[] numbers, int target, int index, int sum) {

        if (index == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }

        dfs(numbers, target, index + 1, sum + numbers[index]);
        dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}
