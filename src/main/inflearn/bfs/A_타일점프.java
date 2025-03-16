package main.inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class A_타일점프 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 2, 1, 1};
        int result = solution(nums);
        System.out.println("result = " + result);
    }

    public static int solution(int[] nums) {
        int n = nums.length;
        int[] ch = new int[n];
        ch[0] = 1;
        int L = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(0);
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                for (int j = 1; j <= nums[x]; j++) {
                    int nx = x + j;
                    if (nx == n - 1) {
                        return L + 1;
                    }
                    if (nx < n && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return -1;
    }
}
