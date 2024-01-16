package main.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 연속_부분_수열_합의_개수 {
    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};
        Solution solution = new Solution();
        int result = solution.solution(elements);
        System.out.println("result = " + result);
    }
    static class Solution {
        public int solution(int[] elements) {
            Set<Integer> set = new HashSet<>();
            int elementsLength = elements.length;

            int[] newElements = new int[elementsLength * 2];

            for (int i = 0; i < newElements.length; i++) {
                newElements[i] = elements[i % elementsLength];
            }

            for (int i = 0; i < elementsLength; i++) {
                int sum = elements[i];
                for (int j = i, t = 0; t < elementsLength; j++, t++) {
                    if (i == j) {
                        set.add(newElements[j]);
                        continue;
                    }
                    sum += newElements[j];
                    set.add(sum);
                }
            }

            return set.size();
        }
    }
}
