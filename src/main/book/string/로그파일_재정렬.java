package main.book.string;

import java.util.ArrayList;
import java.util.List;

public class 로그파일_재정렬 {

    public static void main(String[] args) {

    }
    /*
    로그를 재정렬하라. 기준은 다음과 같다.
    * 1. 로그의 가장 앞 부분은 식별자로서, 순서에 영향을 끼치지 않는다.
    * 2. 문자로 구성된 로그가 숫자 로그보다 앞에 오며, 문자 로그는 사전순으로 한다.
    * 3. 문자가 동일할 경우에는 식별자순으로 한다.
    * 4. 숫자로그는 입력 순서대로 한다.

    in  : ["id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero"]
    out : ["id2 art can", "id5 art zero", "id4 own kit dig", "id1 8 1 5 1", "id3 3 6"]
    * */
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        for (String log : logs) {
            // 로그 종류 확인 후 숫자 로그라면 숫자 리스트에 삽입
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digitList.add(log);
            } else {
                letterList.add(log);
            }
        }

        // 문자 리스트 정렬
        letterList.sort((s1, s2) -> {
            String[] s1x = s1.split(" ", 2);
            String[] s2x = s2.split(" ", 2);

            // 문자 로그 사전순 비교
            int compared = s1x[1].compareTo(s2x[1]);

            // 문자가 동일한 경우 식별자 비교
            if (compared == 0) {
                return s1x[0].compareTo(s2x[0]);
            }
            return compared;
        });

        letterList.addAll(digitList);

        return letterList.toArray(new String[0]);

    }
}
