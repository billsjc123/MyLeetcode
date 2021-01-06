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
        
        // ָ����һ��ĵ�һ���ڵ�
        Node nextLevel = curLevel.left;
        // ���������һ��ʱcurLevelָ��null
        while (nextLevel != null) {
            // ����ò��һ��Node
            curLevel.left.next = curLevel.right;
            Node tmp = curLevel.right;
            curLevel = curLevel.next;
            tmp.next = null;

            // �ò㴦�����һ���ڵ�
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