package main.book.arraystudy;

import java.util.HashMap;
import java.util.Map;

public class 두_수의_합 {
    public static void main(String[] args) {

    }

    /*
    * 덧셈하여 타깃을 만들 수 있는 배열의 두 숫자 인덱스를 리턴하라
    * 입력 : nums = [2, 6, 11, 15], target = 8
    * 출력 : [0, 1]
    * nums[0] + nums[1] = 2 + 6 = 8, 따라서 0,1을 리턴한다.
    *
    */

    /*
    * 배열을 두번 반복하면서 모든 조합을 더해서 일일이 확인해보는 무차별 대입 방식인 브루트 포스
    * 시간 복잡도 : n 2제곱
    * */
    public static int[] twoSum1(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    /*
    * 첫번째 수를 뺀 결과 키 조회
    * 시간 복잡도 : O(1)
    * */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        // 키와 값을 바꿔서 맵으로 저장
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        // target에서 첫번째 수를 뺀 결과를 키로 조회하고 현재 인덱스가 아닌 경우 정답으로 리턴
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - numsMap.get(nums[i])) && i != numsMap.get(target - nums[i])) {
              return new int[]{i, numsMap.get(target - nums[i])};
            }
        }

        return null;
    }

    /*
    * 주회 구조 개선
    * */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // target에서 num을 뺀 값이 있으면 정답으로 리턴
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target - nums[i]), i};
            }
            // 정답이 아니므로 다음번 비교를 위해 인덱스를 맵에 저장
            numsMap.put(nums[i], i);
        }
        return null;
    }
}

