package main.inflearn.greedy;

import java.util.*;

public class F_최대_인원수 {
    public static void main(String[] args) {
        int[][] trains = {{1, 4, 2}, {2, 5, 1}};
        int[][] bookings =  {{1, 2}, {1, 5}, {2, 5}, {2, 4}, {2, 5}, {2, 3}, {3, 5}, {3, 4}};

        int result = solution(5, trains, bookings);
        System.out.println("result = " + result);
    }

    public static int solution(int n, int[][] trains, int[][] bookings) {
        int answer = 0;
        int[] sum = new int[n + 1];
        for (int[] x : trains) {
            sum[x[0]] += x[2];
            sum[x[1]] -= x[2];
        }
        for (int i = 1; i <= n; i++) {
            sum[i] += sum[i - 1];
        }
        int bN = bookings.length;
        Arrays.sort(bookings, (o1, o2) -> o1[0] - o2[0]);
        LinkedList<Integer> nums = new LinkedList<>();
        int ix = 0;
        for (int i = 1; i <= n; i++) {
            while (!nums.isEmpty() && nums.peek() == i) {
                answer++;
                nums.pollFirst();
            }
            while (ix < bN && bookings[ix][0] == i) {
                nums.add(bookings[ix][1]);
                ix++;
            }
            Collections.sort(nums);
            while (nums.size() > sum[i]) {
                nums.pollLast();
            }
        }
        return answer;
    }
}
