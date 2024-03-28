package main.book.arraystudy;

public class 빗물_트래핑 {
    public static void main(String[] args) {
        int[] input = {1,1,0,2,1,0,1,3,2,1,2,1};
        int result = trap(input);
        System.out.println("result = " + result);
    }

    /*
    * 높이를 받아 비 온 후 얼마나 많은 물이 쌓일 수 있는지 계산하라.
    * 입력 : [1,1,0,2,1,0,1,3,2,1,2,1]
    * 출력 : 6
    *
    * 이 문제는 높이와 너비 모든 공간을 차례로 모두 살펴보면 O(n제곱) 풀이가 가능하다.
    * 그러나 시간 복잡도가 너무 높기 떄문에 좀더 효율적인 풀이를 찾아야 한다.
    * 투포인터나 스택으로 O(n) 풀이가 가능할 것 같다.
    * */
    
    public static int trap(int[] height) {
        int volume = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        // 투 포인터가 서로 겹칠 때 까지 반복
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if (leftMax <= rightMax) {
                // 왼쪽 막대 최대 높이와의 차이를 더하고 왼쪽 포인터 이동
                volume += leftMax - height[left];
                left += 1;
            } else {
                // 오른쪽 막대 최대 높이와의 차이를 더하고 오른쪽 포인터 이동
                volume += rightMax - height[right];
                right -= 1;
            }
        }
        return volume;
    }
}
