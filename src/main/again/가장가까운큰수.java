package main.again;

import java.util.ArrayList;
import java.util.List;

public class 가장가까운큰수 {

    private static boolean[] visited;
    private static boolean flag;
    private static List<Integer> nums;
    private static int target;
    private static int m;
    private static int answer;

    private static int solution(int n) {

        target = n;
        flag = false;
        nums = new ArrayList<>();
        m = 0;

        int tmp = n;
        while (tmp != 0) {
            nums.add(tmp % 10);
            tmp /= 10;
            m++;
        }

        nums.sort((a, b) -> a - b);
        visited = new boolean[m];

        dfs(0, 0);
        if (flag == false) return  -1;

        return answer;
    }

    private static void dfs(int L, int number) {
        if (flag) return;

        if (L == m) {
            if (number > target) {
                flag = true;
                answer = number;
            }
        } else {
            for (int i = 0; i < m; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(L + 1, number * 10 + nums.get(i));
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 20573;

        int result = solution(n);
        System.out.println("result = " + result);
    }
}
