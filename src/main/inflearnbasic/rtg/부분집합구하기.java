package main.inflearnbasic.rtg;

public class 부분집합구하기 {
    static int n; // 집합의 원소 갯수
    static int[] ch;

    public static void dfs(int L) {
        if (L == n + 1) {

        } else {
            ch[L] = 1;
            dfs(L + 1);
            ch[L] = 0;
            dfs(L + 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        ch = new int[n + 1];
        dfs(1);
    }
}
