package main.lecture;

import java.util.Arrays;

public class LectureSeat {
    public static void main(String[] args) {
        int[] result = solution(6, 5, 20);
        System.out.println("result = " + Arrays.toString(result));
    }

    public static int[] solution(int c, int r, int k) {
        int[] answer = {1,1};
        int dn = 0;
        int startX = 2, startY = 1;
        int[][] d = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        for (int i = 1; i < k; i++) {

            answer[0] += d[dn][0];
            answer[1] += d[dn][1];

            if (dn == 0 && r == answer[1]) {
                r--;
                dn = (dn + 1) % 4;
            } else if (dn == 1 && c == answer[0]) {
                c--;
                dn = (dn + 1) % 4;
            } else if (dn == 2 && startY == answer[1]) {
                startY++;
                dn = (dn + 1) % 4;
            } else if (dn == 3 && startX == answer[0]) {
                startX++;
                dn = (dn + 1) % 4;
            }
        }

        return answer;
    }
}
