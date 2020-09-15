public class Leetcode_112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return dfs(root, sum, 0);
    }

    public boolean dfs(TreeNode node, int target, int cur_sum) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null && cur_sum + node.val == target)
            return true;
        return dfs(node.left, target, cur_sum + node.val) || dfs(node.right, target, cur_sum + node.val);
    }
}
