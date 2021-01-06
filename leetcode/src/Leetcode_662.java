import java.util.LinkedList;
import java.util.Queue;

class Node {
    TreeNode node;
    int depth, pos;

    Node(TreeNode n, int d, int p) {
        node = n;
        depth = d;
        pos = p;
    }
}

public class Leetcode_662 {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(root, 1, 1));
        int left = 1, curDepth = 1;
        int ans = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.depth > curDepth) {
                curDepth = node.depth;
                left = node.pos;
            }
            if (node.node.left != null)
                q.add(new Node(node.node.left, curDepth + 1, 2 * node.pos));
            if (node.node.right != null)
                q.add(new Node(node.node.right, curDepth + 1, 2 * node.pos + 1));
            ans = Math.max(ans, node.pos - left + 1);
        }
        return ans;
    }
}
