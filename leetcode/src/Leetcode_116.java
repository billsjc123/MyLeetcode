class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Leetcode_116 {
    public Node connect(Node root) {
        if (root == null)
            return null;

        root.next = null;
        Node curLevel = root;
        
        // 指向下一层的第一个节点
        Node nextLevel = curLevel.left;
        // 处理完最后一层时curLevel指向null
        while (nextLevel != null) {
            // 处理该层第一个Node
            curLevel.left.next = curLevel.right;
            Node tmp = curLevel.right;
            curLevel = curLevel.next;
            tmp.next = null;

            // 该层处理到最后一个节点
            while (curLevel != null) {
                tmp.next = curLevel.left;
                curLevel.left.next = curLevel.right;
                tmp = curLevel.right;
                curLevel = curLevel.next;
                tmp.next = null;
            }

            curLevel = nextLevel;
            nextLevel = curLevel.left;
        }

        return root;

    }
}