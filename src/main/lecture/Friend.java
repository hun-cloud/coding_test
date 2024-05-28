package main.lecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Friend {
    public static void main(String[] args) {
        String[][] friends = {
                {"김회철", "조성일"},
                {"조성일", "김진혁"},
                {"이재훈", "조성일"}};
        String[] result = solution(friends, "김회철");
        System.out.println(Arrays.toString(result));
    }

    public static String[] solution(String[][] friends, String username) {
        List<String> friendList = new ArrayList<>();
        PriorityQueue<String> result = new PriorityQueue<>();

        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends[i].length; j++) {
                String name = friends[i][j];
                if (name.equals(username)) {
                    friendList.add(j == 0 ? friends[i][1] : friends[i][0]);
                    friends[i] = null;
                    break;
                }
            }
        }

        for (int i = 0; i < friendList.size(); i++) {
            String name = friendList.get(i);
            for (String[] friend : friends) {
                if (friend == null) {
                    continue;
                }
                for (int j = 0; j < friend.length; j++) {
                    String compareName = friend[j];
                    if (compareName.equals(name)) {
                        result.add(j == 0 ? friend[1] : friend[0]);
                    }
                }
            }
        }
        return result.toArray(new String[0]);
    }
}
