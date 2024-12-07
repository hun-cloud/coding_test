package main.inflearn.시뮬레이션과구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 회의실만남 {
    public static void main(String[] args) {
        int[] enter = {1, 2, 5, 3, 4};
        int[] exit = {2, 3, 1, 4, 5};
        int[] solution = solution(enter, exit);
        System.out.println("Arrays.toString(solution) = " + Arrays.toString(solution));

    }

    public static int[] solution(int[] enter, int[] exit) {
        List<Integer> room = new ArrayList<>();
        int[] result = new int[enter.length];

        for (int i = 0, j = 0; i < enter.length; i++) {
            int exitPerson = exit[j];
            if (!room.isEmpty() && exitPerson == enter[i]) {
                result[exitPerson - 1] = room.size();
                for (int roomPerson : room) {
                    result[roomPerson - 1] += 1;
                }
                j++;
                continue;
            }

            for (int k = 0; k < room.size(); k++) {
                if (exitPerson == room.get(k)) {
                    room.remove(k);
                }
            }

            room.add(enter[i]);

            if (room.size() == 1) {
                continue;
            }

            for (int roomPerson : room) {
                result[roomPerson -1] += 1;
            }
        }

        return result;
    }
}
