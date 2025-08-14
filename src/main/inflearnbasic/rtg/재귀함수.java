package main.inflearnbasic.rtg;

public class 재귀함수 {
    public static void main(String[] args) {

        int n = 3;
        solution(n);
    }

    private static void solution(int n) {
        dfs(n);
    }

    private static void dfs(int n) {

        if (n == 0) return;
        else {
            dfs(n - 1);
            System.out.println(n);
        }
    }
}
