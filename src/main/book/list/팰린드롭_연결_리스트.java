package main.book.list;

import java.util.Deque;
import java.util.LinkedList;

public class 팰린드롭_연결_리스트 {
    /**
     * 연결리스트가 팰린드롬 구조인지 판별하라
     * input : 1 -> 2 -> 3 -> 2 -> 1
     * output : true
     * Stack은 이제 사용하지 말자
     * */


    /**
     * 러너를 이용한 우아한 풀이
     * 팬린드롬 연결 리스트 문제의 제대로 된 풀이법은 러너 기법을 활용하는 것이다.
     *
     * */
//    public boolean isPalindrome(ListNode head) {
//        ListNode fast = head, slow = head;
//        // 빠른 러너가 끝까지 갈 때까지 느린 러너와 함께 진행
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        // 홀수 개일 때 느린 러너가 한 칸 더 앞으로 가도록 처리
//
//    }


    /**
     * 앞뒤 모두 추출할 수 있는 자료구조는 Deque이다.
     * 데크는 이중 연결 리스트 구조로 양쪽 방향 모두 추출하는데 시작복잡도 O(1)이 걸린다.
     * */

    public boolean isPalindrome1(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        // 연결 리스트를 데크에 삽입
        ListNode node = head;
        while (node != null) {
            deque.add(node.val);
            node = node.next;
        }

        // 데크가 모두 비거나(짝수 개일 때) 1개 이하(홀수 개일 때) 가 될 때까지 비교
        while (!deque.isEmpty() && deque.size() > 1) {
            // 데크 양 끝을 추출해 팰린드롭 여부 확인
            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;
    }
}
