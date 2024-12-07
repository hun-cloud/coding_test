package main.inflearn.시뮬레이션과구현;


import java.util.Arrays;
import java.util.stream.IntStream;

public class 과일가져가기 {
    public static void main(String[] args) {
        int[][] fruit =  {{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15,
                10, 5}, {3, 7, 20}};
        int solution = solution(fruit);
        System.out.println("solution = " + solution);
    }

    public static int solution(int[][] fruit) {

        int[] ch = new int[fruit.length];
        for (int i = 0; i < fruit.length; i++) {
            if (ch[i] == 1) continue;
            int[] fruitArr = fruit[i];
            int min = getMin(fruitArr);
            if (isNotUniqueMin(fruitArr, min)) continue;

            for (int j = i + 1; j < fruit.length; j++) {
                if (ch[i] == 1) continue;
                int[] comparativeFruit = fruit[j];
                int comparativeFruitMin = getMin(comparativeFruit);
                if (isNotUniqueMin(comparativeFruit, comparativeFruitMin)) continue;
                int a = getMinIndex(fruitArr, min);
                int b = getMinIndex(comparativeFruit, comparativeFruitMin);

                if (a != b && fruit[i][b] > 0 && fruit[j][a] > 0) {
                    if (fruit[i][a] + 1 <= fruit[i][b] && fruit[j][b] + 1 <= fruit[j][a] - 1) {
                        fruit[i][a]++;
                        fruit[i][b]--;
                        fruit[j][b]++;
                        fruit[j][a]--;
                        ch[i] = 1;
                        ch[j] = 1;
                        break;
                    }
                }
            }
        }
        Arrays.stream(fruit).forEach(i -> System.out.println(Arrays.toString(i)));


        return Arrays.stream(fruit)
                .mapToInt(i -> getMin(i))
                .sum();
    }

    private static int getMinIndex(int[] fruitArr, int min) {

        return IntStream.range(0, fruitArr.length)
                .filter(i -> fruitArr[i] == min)
                .findFirst()
                .orElse(-1);
    }

    private static boolean isNotUniqueMin(int[] fruitArr, int min) {
        return Arrays.stream(fruitArr)
                .filter(v -> v == min)
                .count() != 1;
    }

    private static int getMin(int[] fruitArr) {
        return Arrays.stream(fruitArr)
                .min()
                .getAsInt();
    }
}
