package main.again;

public class 카펫 {
    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        System.out.println((int) Math.sqrt(12));
        int[] result = solution(brown, yellow);
    }

    private static int[] solution(int brown, int yellow) {

        int count = brown + yellow;
        int sqrt = (int) Math.sqrt(count);

        int garo = 0;
        for (int i = sqrt; i >= 1; i--) {
            if (count % i == 0 && (i - 2) * (count / i - 2) == yellow) {
                garo = i;
                break;
            }
        }
        return new int[]{garo, count / garo};

    }
}
