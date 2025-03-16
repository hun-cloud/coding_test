package main.inflearn.greedy;

import java.util.Arrays;

public class D_꽃이_피는_최단시간 {
    public static void main(String[] args) {
        int[] plantTime = {1, 2, 3, 4, 5, 6, 7};
        int[] growTime = {7, 5, 4, 3, 2, 1, 6};
        int result = solution(plantTime, growTime);
        System.out.println("result = " + result);
    }

    public static int solution(int[] plantTime, int[] growTime) {
        int day = 0;
        int[] resultArr = new int[plantTime.length];

        for (int i = 0; i < plantTime.length; i++) {
            resultArr[i] = day + plantTime[i] + growTime[i];
            day += plantTime[i];
        }

        return Arrays.stream(resultArr).max().getAsInt();
    }
}
