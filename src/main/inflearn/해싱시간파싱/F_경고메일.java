package main.inflearn.해싱시간파싱;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class F_경고메일 {

    private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm");

    public static void main(String[] args) throws Exception{
        String[] reports = {"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"};
        int time = 120;
        String[] solution = solution(reports, time);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public static String[] solution(String[] reports, int time) throws Exception{
        Map<String, Long> personTimeMap = getReportMap(reports);

        List<String> warningList = getWorningList(personTimeMap, time);

        Collections.sort(warningList);

        return warningList.toArray(new String[0]);
    }

    private static List<String> getWorningList(Map<String, Long> personTimeMap, int time) {
        List<String> warningList = new ArrayList<>();

        for (String key : personTimeMap.keySet()) {
            if (personTimeMap.get(key) > time) {
                warningList.add(key);
            }
        }

        return warningList;
    }

    private static Map<String, Long> getReportMap(String[] reports) throws ParseException {

        Map<String, Date> reportMap = new HashMap<>();
        Map<String, Long> personTimeMap = new HashMap<>();

        for (String report : reports) {
            String[] s = report.split(" ");

            if (reportMap.containsKey(s[0])) {
                Date inTime = reportMap.get(s[0]);
                Date outTime = format.parse(s[1]);
                long stayTime = (outTime.getTime() - inTime.getTime()) / (1000 * 60);

                personTimeMap.put(s[0], personTimeMap.getOrDefault(s[0], 0L) + stayTime);
                reportMap.remove(s[0]);
                continue;
            }

            reportMap.put(s[0], format.parse(s[1]));
        }

        return personTimeMap;
    }
}
