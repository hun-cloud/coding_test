package main.inflearn.시뮬레이션과구현;

import java.util.Arrays;

public class 좌석번호 {
    public static void main(String[] args) {
        int[] result = solution(6, 5, 31);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int c, int r, int k) {

        if (c * r < k) {
            return new int[] {0, 0};
        }

        int[] maxCountArr = {r, c, 1, 2};
        int direction = 0;
        int[] result = {1, 1};

        for (int i = 0; i < k - 1; i++) {
            System.out.println(Arrays.toString(result));
            switch (direction) {
                case 0 -> {
                    if (result[1] + 1 == maxCountArr[0]) {
                        direction = (direction + 1) % 4;
                        maxCountArr[0] -= 1;
                    }
                    result[1] += 1;
                }
                case 1 -> {
                    if (result[0] + 1 == maxCountArr[1]) {
                        direction = (direction + 1) % 4;
                        maxCountArr[1] -= 1;
                    }
                    result[0] += 1;
                }
                case 2 -> {
                    if (result[1] - 1 == maxCountArr[2]) {
                        direction = (direction + 1) % 4;
                        maxCountArr[2] += 1;
                    }
                    result[1] -= 1;
                }
                case 3 -> {
                    if (result[0] - 1 == maxCountArr[3]) {
                        direction = (direction + 1) % 4;
                        maxCountArr[3] += 1;
                    }
                    result[0] -= 1;
                }
                default -> throw new RuntimeException("에러 발생");
            }
        }
        return result;
    }
}
