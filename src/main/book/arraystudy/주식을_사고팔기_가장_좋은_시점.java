package main.book.arraystudy;

public class 주식을_사고팔기_가장_좋은_시점 {

    /**
     * 한번의 거래로 낼 수 있는 최대 이익을 산출하라
     * 입력 : [8, 1, 5, 3, 6, 4]
     * 출력 : 5
     * 설명 1일 때 사서 6일 때 사면 최대 5의 이익을 얻는다.
     * */
    public static void main(String[] args) {
        int[] input = {8, 1, 5, 3, 6, 4};
        System.out.println(maxProfit1(input));

    }

    // 브르투 포스 계산
    public static int maxProfit1(int[] prices) {
        int maxProfit = 0;
        // 구매 시점 순회, 처음부터 끝까지 차례대로 반복한다.
        for (int i = 0; i < prices.length; i++) {
            // 판매시점 순회, 구매 다음부터 끝까지 차례대로 반복한다.
            for (int j = i + 1; j < prices.length; j++) {
                // 판매 시점 가격에서 구매 시점 가격을 뺄 때 가장 높은 금액 찾기
                maxProfit = Math.max(maxProfit, prices[i] - prices[j]);
            }
        }
        return maxProfit;
    }
}
