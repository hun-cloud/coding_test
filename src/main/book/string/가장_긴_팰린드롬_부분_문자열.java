package main.book.string;

public class 가장_긴_팰린드롬_부분_문자열 {
    public static int left = 0, maxLen = 0;

    public static void main(String[] args) {
        String str = "dcbabcdd";

        String result = longestPalindrome(str);
        System.out.println("result = " + result);
    }
    /*
     * 가장 긴 패린드롬 부분 문자열을 출력하라
     * in : dcbabcdd
     * out : dcbabcd
     * */
    private static String longestPalindrome(String str) {

        if (str.length() < 2) {
            return str;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            extendPalindrome(str, i, i + 1);
            extendPalindrome(str, i, i + 2);
        }

        return str.substring(left, left + maxLen);
    }

    private static void extendPalindrome(String str, int x, int y) {
        
        while (x >= 0 && y < str.length() && str.charAt(x) == str.charAt(y)) {
            x--;
            y++;
        }
        
        if (maxLen < y - x - 1) {
            left = x + 1;
            maxLen = y - x - 1;
        }
    }
}
