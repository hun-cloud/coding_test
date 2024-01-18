package main.book.string;

/*
* 팰린드롬 : 앞뒤가 똑같은 단어나 문장
*
* */
public class 팰린드롬 {

    public static void main(String[] args) {
        System.out.println("1 : " + isPalindrome1("12321"));
        System.out.println("2 : " + isPalindrome1("12321"));
    }

    public static boolean isPalindrome1(String s) {
        int start = 0;
        int end = s.length() -1;

        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else { // 유효한 문자라면 앞 글자와 윗글자를 모두 소문자로 변경해 비교
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        String s_filtered = s.replace("[^a-zA-Z0-9]", "").toLowerCase();

        String s_reversed = new StringBuilder(s_filtered).reverse().toString();

        return s_filtered.equals(s_reversed);
    }

}
