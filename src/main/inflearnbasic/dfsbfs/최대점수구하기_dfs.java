package main.inflearnbasic.dfsbfs;

public class 최대점수구하기_dfs {

    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) {
        int[] score = {5, 10, 25, 15, 6, 7};
        int[] time = {20, 5, 12, 8, 3, 4};

        visited = new boolean[score.length];

        dfs(0, 0, 0, score, time);
    }

    private static void dfs(int L, int scoreSum, int timeSum, int[] score, int[] time) {

    }
}
