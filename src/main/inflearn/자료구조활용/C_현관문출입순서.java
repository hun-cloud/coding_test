package main.inflearn.자료구조활용;

import java.util.*;

public class C_현관문출입순서 {
    public static void main(String[] args) {

    }

    public static int[] solution(int[] arrival, int[] state) {
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        int n = arrival.length;
        int prev = 1; // 0 : 들어오는 사원, 1 : 나가는 사원
        int[] answer = new int[n];

        for (int t = 0, i = 0, cnt = 0; ; t++) {

            // cnt : 처리된 사원 수
            // i : 인덱스 역할
            // t : 시간
            
            if (enter.isEmpty() && exit.isEmpty() && i < n) {
                if (t < arrival[i]) {
                    t = arrival[i];
                    prev = 1;
                }
            }
            while (i < n && arrival[i] <= t) {
                if (state[i] == 0) {
                    if (state[i] == 0) enter.offer(i);
                } else {
                    exit.offer(i);
                }
                i++;
            }
            if (prev == 1) {
                if (!exit.isEmpty()) {
                    answer[exit.poll()] = t;
                    prev = 1;
                } else {
                    answer[enter.poll()] = t;
                    prev = 0;
                }
            } else if (prev == 0) {
                if (!enter.isEmpty()) {
                    answer[enter.poll()] = t;
                    prev = 0;
                } else {
                    answer[exit.poll()] = t;
                    prev = 1;
                }
            }
            cnt++;
            if (cnt == n) {
                break;
            }
        }
        return answer;
    }
}
