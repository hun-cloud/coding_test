package main.inflearnbasic.rtg;

public class 이진트리순회 {
    Node root;

    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.lt);
        dfs(root.rt);
    }

    public static void main(String[] args) {

    }

    static class Node {
        int data;
        Node lt, rt;

        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }
}
