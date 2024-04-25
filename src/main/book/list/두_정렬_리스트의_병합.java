package main.book.list;

import main.book.list.팰린드롭_연결_리스트.ListNode;

public class 두_정렬_리스트의_병합 {
    /**
     * 정렬되어 있는 두 연결리스트를 합쳐라
     * 입력 1 -> 2 -> 5
     *     1 -> 3 -> 4
     * 출력 : 1 -> 1 -> 2 -> 3 -> 4 -> 5
     * */

    /**
     * 정렬된 리스트라는 점이 중요하다. 즉 병합 정렬에서 마지막 조합 시 첫 번째 값부터 차례대로만
     * 비교하면 한번에 해결되듯이, 이 또한 병합 정렬의 마지막 조합과 동일한 방식을 첫번째부터 비교하면서
     * 리턴하면 쉽게 풀 수 있는 문제이다.
     * */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 두 노드 중 한쪽이 널이면 널이 아닌 노드를 리턴
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // l2가 더 크면 l1에 재귀 호출 결과를 엮고 l1을 리턴
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
            // l1보다 더 크거나 같으면 l2에 재귀 호출 결과를 엮고 l2를 리턴
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }


}
