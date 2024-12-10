package main.inflearn.해싱시간파싱;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class E_문서도난 {

    private static final SimpleDateFormat HH_mm_FORMAT = new SimpleDateFormat("HH:mm");

    public static void main(String[] args) throws Exception{
        String[] reports = {"ami 12:56", "daniel 15:00", "bob 19:59",
                "luis 08:57", "bill 17:35", "tom 07:23",
                "john 15:23", "park 09:59"};
        String times = "15:01 19:59";
        String[] solution = solution(reports, times);
        System.out.println("Arrays.toString(solution) = " + Arrays.toString(solution));
    }

    public static String[] solution(String[] solution, String times) throws Exception{
        Date[] timesArr = initTime(times);
        List<Agent> agents = initAgent(solution);
        List<Agent> accessedAgentInTimeList = filterAgent(agents, timesArr);
        return sortAccessedTime(accessedAgentInTimeList);
    }

    private static String[] sortAccessedTime(List<Agent> accessedAgentList) {
        accessedAgentList.sort(Comparator.comparing(Agent::getAccessedTime));
        return accessedAgentList.stream()
                .map(Agent::getName)
                .toArray(String[]::new);
    }

    private static List<Agent> filterAgent(List<Agent> agents, Date[] timesArr) {
        return agents.stream()
                .filter(agent -> {
                    Date accessedTime = agent.getAccessedTime();
                    return (accessedTime.after(timesArr[0]) || accessedTime.equals(timesArr[0])) &&
                            ( accessedTime.before(timesArr[1]) || accessedTime.equals(timesArr[1]));
                }).collect(Collectors.toList());
    }

    private static List<Agent> initAgent(String[] solution) {
        return Arrays.stream(solution)
                .map(item -> {
                    String[] s = item.split(" ");
                    try {
                        return new Agent(s[0], HH_mm_FORMAT.parse(s[1]));
                    } catch (ParseException ignored) {}
                    return null;
                }).toList();
    }

    private static Date[] initTime(String times) throws Exception{
        String[] timeArr = times.split(" ");
        return new Date[]{HH_mm_FORMAT.parse(timeArr[0]), HH_mm_FORMAT.parse(timeArr[1])};
    }

    static class Agent {
        private String name;
        private Date accessedTime;

        public Agent(String name, Date accessedTime) {
            this.name = name;
            this.accessedTime = accessedTime;
        }

        public String getName() {
            return name;
        }

        public Date getAccessedTime() {
            return accessedTime;
        }
    }
}
