package main.inflearnbasic.dfsbfs;

import java.util.Arrays;

public class 합이같은부분집합 {
    static String answer = "NO";
    static int n, total = 0;
    static boolean flag = false;
    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 6, 7, 10};

        total = Arrays.stream(arr).sum();

        dfs(0, 0, arr);
    }

    private static void dfs(int L, int sum, int[] arr) {

        if (flag) return;

        if (L ==n) {
            if (total - sum == sum) {
                answer = "YES";
                flag = true;
            }
        }
        dfs(L + 1, sum + arr[L], arr);
        dfs(L + 1, sum, arr);
    }


}
