package main.inflearn.자료구조활용;

import java.util.*;

public class C_현관문출입순서 {
    public static void main(String[] args) {

    }

    public static int[] solution(int[] arrival, int[] state) {
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        int n = arrival.length;
        int prev = 1;
        int[] answer = new int[n];

        for (int t = 0, i = 0, cnt = 0; ; t++) {
            if (enter.isEmpty() && exit.isEmpty() && i < n) {
                if (t < arrival[i]) {
                    t = arrival[i];
                    prev = 1;
                }
            }
            while (i < n && arrival[i] <= t) {

            }
        }


    }
}
