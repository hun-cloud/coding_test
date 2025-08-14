package main.inflearnbasic.dfsbfs;

public class 바둑이승차 {

    static int sum;
    static int maxSum;
    static int m;
    static int answer;
    static boolean[] visited;

    public static void main(String[] args) {

        maxSum = 259;
        m = 5;
        visited = new boolean[m];
        int[] arr = {81, 58, 42, 33, 61};

        dfs(0, 0, arr);
        System.out.println("answer = " + answer);
    }

    private static void dfs(int L, int sum, int[] arr) {

        if(sum > maxSum) {
            return;
        }
        answer = Math.max(answer, sum);

        for (int i = 0; i < m; i++) {

            if (!visited[i] && sum < maxSum) {
                visited[i] = true;
                dfs(L + 1, sum + arr[i], arr);
                visited[i] = false;
            }
        }
    }
}
