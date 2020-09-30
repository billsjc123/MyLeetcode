public class Leetcode_1372 {
    int maxlen = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, 0, 0);
        dfs(root, 1, 0);
        return maxlen;
    }

    public void dfs(TreeNode node, int direction, int len) {
        // 父节点的左子树
        if (direction == 0)
            if (node.left != null)
                dfs(node.left, 1, 0);
            if (node.right != null)
                dfs(node.right, 0, len+1);
        // 父节点的右子树
        else if (direction == 1)
            if (node.left != null)
                dfs(node.left, 1, len + 1);
            if (node.right != null)
                dfs(node.right, 0, 0);
        maxlen = Math.max(len, maxlen);
    }
}
