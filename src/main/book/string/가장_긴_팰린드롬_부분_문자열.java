package main.book.string;

public class 가장_긴_팰린드롬_부분_문자열 {
    public static int left = 0, maxLen = 0;

    public static void main(String[] args) {

    }
    /*
    * 가장 긴 패린드롬 부분 문자열을 출력하라
    * in : dcbabcdd
    * out : dcbabcd
    * */

    public static String 부분_문자열_구하기() {

        String s = "dcbabcdd";

        int len = s.length();
        if (len < 2) {
            return s;
        }
        for (int i = 0; i < len -1; i++) {
            extendPalindrome(s, i, i + 1);
            extendPalindrome(s, i, i + 2);
        }
        return s.substring(left, left + maxLen);
    }

    public static void extendPalindrome(String s, int j, int k) {
        // 투 포인터가 유효한 범위 내에 있고 양쪽 끝 문자가 일치하는 팰린드롬인 경우 범위 확장
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        // 기존 최대 길이보다 큰 경우 값 교체
        if (maxLen < k - j - 1) {
            left = j + 1;
            maxLen = k - j - 1;
        }
    }
}
