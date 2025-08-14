package main.inflearnbasic.rtg;

import java.util.LinkedList;
import java.util.Queue;

public class Tree말단노드까지의가장짧은경로_bfs {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.leftNode = new Node(2);
        root.rightNode = new Node(3);
        root.leftNode.leftNode = new Node(4);
        root.leftNode.rightNode = new Node(5);
        root.rightNode = new Node(3);

        int answer = bfs(0, root);

        System.out.println("answer = " + answer);
    }

    private static int bfs(int L, Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int m = queue.size();

            for (int i = 0; i < m; i++) {
                Node current = queue.poll();
                Node leftNode = current.leftNode;
                Node rightNode = current.rightNode;

                if (leftNode == null && rightNode == null) {
                    return L;
                }

                if (leftNode != null) {
                    queue.offer(leftNode);
                }

                if (rightNode != null) {
                    queue.offer(rightNode);
                }
            }
            L++;
        }
        return 0;
    }

    static class Node {
        int num;
        Node leftNode;
        Node rightNode;

        public Node(int num) {
            this.num = num;
        }
    }
}
