public class Leetcode_1302 {
    int maxdep = 0;
    int ans = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 1);
        return ans;
    }

    void dfs(TreeNode root, int depth) {
        if (depth > maxdep) {
            ans = 0;
            maxdep = depth;
        }
        if (depth == maxdep) {
            ans += root.val;
        }
        if (root.left != null) {
            dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            dfs(root.right, depth + 1);
        }
    }
}
