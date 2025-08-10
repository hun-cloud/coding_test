package main.inflearn.그래프알고리즘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_최소_비행료 {
    public static void main(String[] args) {
        int n = 5;
        int[][] flights = {{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3,
                80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}};
        int s = 0;
        int e = 3;
        int k = 1;

        int result = solution(n, flights, s, e, k);
        System.out.println("result = " + result);
    }

    public static int solution(int n, int[][] flights, int s, int e, int k) {
        int result = 0;

        /**
         * n : n개의 도시가 있음
         * flights : [출발지, 도착지, 요금]
         * s : 현수가 사는 도시
         * e : 목적지 도시
         * k : 최대 환승 가능
         * 최소 금액으로 목적지 도착하기
         * */

        Arrays.sort(flights, (a, b) -> a[0] - b[0]);
        List<List<int[]>> stopList = new ArrayList<>();

        for (int[] flight : flights) {
            List<int[]> infos = stopList.get(flight[0]);
            System.out.println(infos);
            if (infos == null) {
                System.out.println("he");
            }

        }

        System.out.println(stopList);

        return result;
    }
}

