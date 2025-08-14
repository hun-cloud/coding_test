package main.temp;

import java.util.PriorityQueue;

public class 배열에서_k번째로_큰_요소 {
    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int result = solution(nums, k);
        System.out.println("result = " + result);
    }

    private static int solution(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

}
