package main.inflearn.dfs;

import java.util.Arrays;
import java.util.Comparator;

public class A_가장_가까운_큰수 {

    public static void main(String[] args) {
        int n = 54312;
        int solution = solution(n);
        System.out.println("solution = " + solution);
    }

    public static int solution(int n) {

        if (isMax(n)) {
            return -1;
        }

        String str = String.valueOf(n);
        String[] split = str.split("");
        for (int i = 2; i <= split.length; i++) {
            String[] rangeSplit = Arrays.copyOfRange(split, split.length - i, split.length);
            String maxStr = Arrays.stream(rangeSplit).max(String::compareTo).get();

            if (rangeSplit[0].equals(maxStr)) {
                continue;
            }

            Arrays.sort(rangeSplit);

            String[] sortedWithoutMaxValue = Arrays.copyOfRange(rangeSplit, 0, rangeSplit.length - 1);

            String sortedValue = maxStr + String.join("", sortedWithoutMaxValue);

            String resultStr = str.substring(0, str.length() - sortedValue.length()) + sortedValue;

            if (!str.equals(resultStr)) {
                return Integer.valueOf(resultStr);
            }
        }

        return -1;
    }

    private static boolean isMax(int n) {

        String str = String.valueOf(n);
        String[] split = str.split("");
        Arrays.sort(split, Comparator.reverseOrder());
        String sortedStr = String.join("", split);
        return str.equals(sortedStr);
    }
}
