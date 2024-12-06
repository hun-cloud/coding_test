package main.inflearn.시뮬레이션과구현;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 비밀번호 {
    public static void main(String[] args) {
        int[] keypad = {1, 5, 7, 3, 2, 8, 9, 4, 6};
        String password = "63855526592";
        int solution = solution(keypad, password);
        System.out.println("solution = " + solution);
    }
    public static int solution(int[] keypad, String password) {
        int result = 0;
        int[] passwordArr = getPasswordArr(password);
        Map<Integer, int[]> keypadMap  = getKeyPadMap(keypad);

        for (int i = 1; i < passwordArr.length; i++) {
            int[] nextPassword = keypadMap.get(passwordArr[i]);
            int[] prePassword = keypadMap.get(passwordArr[i - 1]);

            if (prePassword[0] == nextPassword[0] && prePassword[1] == nextPassword[1]) {
                continue;
            }

            if (Math.abs(prePassword[0] - nextPassword[0]) == 2
                || Math.abs(prePassword[1] - nextPassword[1]) == 2) {
                result += 2;
                continue;
            }

            result++;
        }
        return result;
    }

    private static Map<Integer,int[]> getKeyPadMap(int[] keypad) {
        Map<Integer, int[]> keypadMap = new HashMap<>();
        int i = 0;
        int j = 0;
        for (int key : keypad) {
            keypadMap.put(key, new int[] {i, j});
            j++;
            if (j % 3 == 0) {
                i++;
                j = 0;
            }
        }
        return keypadMap;
    }

    private static int[] getPasswordArr(String password) {
        return Arrays.stream(password.split(""))
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}
