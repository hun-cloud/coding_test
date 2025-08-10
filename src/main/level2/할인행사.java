package main.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 할인행사 {
    public static void main(String[] args) {
        String[] want = {"apple"};
        int[] number = {10};
        String[] discount = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};
        int result = solution(want, number, discount);

        System.out.println("result = " + result);
    }

    public static int solution(String[] want, int[] number, String[] discount) {

        int numberSum = Arrays.stream(number).sum();

        Map<String, Integer> discountMap = initDiscountMap(discount, numberSum);

        return canJoinDayCount(want, number, discount, discountMap, numberSum);
    }

    private static int canJoinDayCount(String[] want, int[] number, String[] discount,
                                       Map<String, Integer> discountMap, int numberSum) {
        int result = 0;

        for (int i = 0; i < discount.length + 1 - numberSum; i++) {
            System.out.println(i);
            for (int j = 0; j < want.length; j++) {
                if (discountMap.get(want[j]) == null || discountMap.get(want[j]) != number[j]) {
                    break;
                }
                if (j == want.length - 1) {
                    result++;
                }
            }

            if (i == discount.length - numberSum) {
                break;
            }

            discountMap.put(discount[i], discountMap.get(discount[i]) - 1);
            discountMap.put(discount[i + numberSum], discountMap.getOrDefault(discount[i + numberSum], 0) + 1);
        }
        
        return result;
    }

    private static Map<String, Integer> initDiscountMap(String[] discount, int numberSum) {
        Map<String, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < numberSum; i++) {
            resultMap.put(discount[i], resultMap.getOrDefault(discount[i], 0) + 1);
        }

        return resultMap;
    }
}
