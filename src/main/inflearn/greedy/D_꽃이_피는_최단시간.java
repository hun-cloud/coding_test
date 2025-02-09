package main.inflearn.greedy;

import java.util.Arrays;

public class D_꽃이_피는_최단시간 {
    public static void main(String[] args) {
        int[] plantTime = {2, 1, 4, 3};
        int[] growTime = {2, 5, 3, 1};
        solution(plantTime, growTime);
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
