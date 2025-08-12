package main.level2;

public class 피로도 {

    private static int maxCount = 0;

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int result = solution(k, dungeons);

        System.out.println("result = " + result);
    }

    private static int solution(int k, int[][] dungeons) {

        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return maxCount;
    }

    private static void dfs(int currentStamina, int[][] dungeons, boolean[] visited, int count) {

        if (count > maxCount) {
            maxCount = count;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) {
                continue;
            }

            int required = dungeons[i][0];
            int consume = dungeons[i][1];

            if (currentStamina >= required) {
                visited[i] = true;
                dfs(currentStamina - consume, dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
    }
}
