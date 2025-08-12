package main.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 프로세스 {

    public static void main(String[] args) {

    }

    public static int solution(int[] priorities, int location) {

        Queue<Process> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process(i, priorities[i]));
        }

        int order = 0;

        while (!queue.isEmpty()) {
            Process current = queue.poll();

            boolean hasHigherPriority = queue.stream()
                    .anyMatch(p -> p.priority > current.priority);

            if (hasHigherPriority) {
                queue.add(current);
            } else {
                order++;
                if (current.index == location) {
                    return order;
                }
            }
        }
        return order;
    }

    static class Process {
        private int index;
        private int priority;

        public Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
