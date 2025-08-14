package main.again;

import java.util.Arrays;
import java.util.Collections;

public class 최소공배수 {
    public static void main(String[] args) {

        int[] arr = {2, 6, 8, 14};

        int result = solutoin(arr);

        System.out.println("result = " + result);
    }

    private static int solutoin(int[] arr) {
        Arrays.sort(arr);
        int answer = arr[arr.length - 1];

        while (true) {
            for (int i = 0; i < arr.length; i++) {
                if (answer % arr[i] != 0) {
                    answer++;
                    break;
                }
                if (i == arr.length - 1) {
                    return answer;
                }
            }
        }
    }
}
