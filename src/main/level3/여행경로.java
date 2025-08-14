package main.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 여행경로 {

    private static List<String> path = new ArrayList<>();
    private static String[] answer;
    private static boolean[] visited;
    private static boolean found = false;

    public static void main(String[] args) {

        String[][] tickets = {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };

        String[] result = solution(tickets);
    }

    private static String[] solution(String[][] tickets) {
        int n = tickets.length;
        visited = new boolean[n];

        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        path.add("ICN");
        dfs("ICN", tickets, 0);
        return answer;
    }

    private static void dfs(String current, String[][] tickets, int used) {

        if (found) {
            return;
        }

        if (used == tickets.length) {
            answer = path.toArray(new String[0]);
            found = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                path.add(tickets[i][1]);

                dfs(tickets[i][1], tickets, used + 1);

                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
