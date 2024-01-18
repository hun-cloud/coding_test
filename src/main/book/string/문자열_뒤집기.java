package main.book.string;

public class 문자열_뒤집기 {
    public static void main(String[] args) {
        reverseString(new char[] {'a','b','c','d' });
    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }
}
