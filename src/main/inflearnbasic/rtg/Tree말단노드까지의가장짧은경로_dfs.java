package main.inflearnbasic.rtg;

public class Tree말단노드까지의가장짧은경로_dfs {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.leftNode = new Node(2);
        root.rightNode = new Node(3);
        root.leftNode.leftNode = new Node(4);
        root.leftNode.rightNode = new Node(5);
        root.rightNode = new Node(3);

        int answer = dfs(0, root);

        System.out.println("answer = " + answer);
    }

    private static int dfs(int L, Node root) {
        if (root.leftNode == null && root.rightNode == null) {
            return L;
        }

        return Math.min(dfs(L + 1, root.leftNode), dfs(L + 1, root.rightNode));
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
