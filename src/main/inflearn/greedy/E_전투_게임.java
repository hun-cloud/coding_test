package main.inflearn.greedy;

import java.util.Arrays;

public class E_전투_게임 {
    public static void main(String[] args) {
        String[] students = {"a 20", "b 12", "a 10", "c 11", "e 12"};

        int[] solution = solution(students);
        System.out.println("Arrays.toString(solution) = " + Arrays.toString(solution));
    }

    public static int[] solution(String[] students) {
        String[] teams = new String[students.length];
        int[] teamAttackValues = new int[students.length];
        int[] results = new int[students.length];

        for (int i = 0; i < students.length; i++) {
            String[] splitStr = students[i].split(" ");
            teams[i] = splitStr[0];
            teamAttackValues[i] = Integer.valueOf(splitStr[1]);
        }

        for (int i = 0; i < teams.length; i++) {
            int result = 0;

            for (int j = 0; j < teams.length; j++) {
                if (teams[i].equals(teams[j])) {
                    continue;
                }

                if (teamAttackValues[i] > teamAttackValues[j]) {
                    result += teamAttackValues[j];
                }
            }
            results[i] = result;
        }

        return results;
    }
}
