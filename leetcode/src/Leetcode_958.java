import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Leetcode_958 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        boolean end = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (end) {
                    if (node.left != null || node.right != null)
                        return false;
                } else {
                    if (node.left != null) {
                        q.add(node.left);
                    } else {
                        end = true;
                    }
                    if (node.right != null) {
                        if (end)
                            return false;
                        q.add(node.right);
                    }else {
                        end = true;
                    }
                }

            }
        }
        return true;
    }
}
