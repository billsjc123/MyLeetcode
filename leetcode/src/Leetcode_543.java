public class Leetcode_543 {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int ldepth = dfs(root.left);
        int rdepth = dfs(root.right);

        if (ldepth + rdepth > ans) {
            ans = ldepth + rdepth;
        }

        return Math.max(ldepth, rdepth) + 1;
    }
}
