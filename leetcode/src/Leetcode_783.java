import java.util.Stack;

public class Leetcode_783 {
    int ans = 0;

    public int minDiffInBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode tmp = root;
        int pre = 0, cur = 0;
        while (tmp != null) {
            s.push(tmp);
            pre = tmp.val;
            tmp = tmp.left;
        }
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            cur = node.val;
            if (cur - pre != 0)
                ans = Math.min(ans, cur - pre);
            pre = cur;

            node = node.right;
            if (node != null)
                s.push(node);
            while (node.left != null) {
                s.push(node.left);
                node = node.left;
            }

        }
        return ans;
    }

}
