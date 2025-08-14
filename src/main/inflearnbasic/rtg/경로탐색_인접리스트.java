package main.inflearnbasic.rtg;

import java.util.ArrayList;

public class 경로탐색_인접리스트 {

    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void dfs(int v) {
        if (v==n) answer++;
        else {
            for(int nv : graph.get(v)) {
                if (!visited[nv]) {
                    visited[nv] = true;
                    dfs(nv);
                    visited[nv] = false;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
