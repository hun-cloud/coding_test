package main.again;

public class 피보나치수 {
    public static void main(String[] args) {

        int result = solution(3);

        System.out.println("result = " + result);
    }

    private static int solution(int n) {
        int MOD = 1234567;
        int a = 0;
        int b = 1;

        for (int i = 2; i <= n; i++) {
            int temp = (a + b) % MOD;
            a = b;
            b = temp;
        }
        return b;
    }
}
