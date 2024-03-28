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

    // 저점과 현재 값과의 차이 계산
    public static int maxProfit2(int[] prices) {
        // 최대 이익은 0, 저점은 임시로 첫 번째 값으로 지정
        int maxProfit = 0, minPrice = prices[0];
        // 형재 값을 우측으로 차례대로 이동하면서 계산
        for (int price : prices) {
            // 지금까지 저점 계산
            minPrice = Math.min(minPrice, price);
            // 현재 값과 저점의 차이가 최대 이익인 경우 교체
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
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
