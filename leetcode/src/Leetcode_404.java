public class Leetcode_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        return dfs(root, false);
    }

    public int dfs(TreeNode node, Boolean isLeft) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null && isLeft)
            return node.val;
        return dfs(node.left, true) + dfs(node.right, false);
    }
}