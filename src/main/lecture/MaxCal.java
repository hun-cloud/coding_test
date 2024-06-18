package main.lecture;

public class MaxCal {
    public static void main(String[] args) {
        long max = max(10);
        System.out.println("max = " + max);
    }

    public static long max(int n) {
        if (n <= 2) return 1;
        if (n == 3) return 2;

        long result = 1;

        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        result *= n;

        return result;
    }
}
