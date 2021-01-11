public class Leetcode_1026 {
    int ans;

    public int maxAncestorDiff(TreeNode root) {
        return ans;
    }

    void dfs(TreeNode root, int pathMax, int pathMin) {
        if (root == null)
            return;

        ans = Math.max(Math.max(Math.abs(pathMax - root.val), Math.abs(pathMin - root.val)), ans);
        pathMax = Math.max(root.val, pathMax);
        pathMin = Math.min(root.val, pathMin);

        dfs(root.left, pathMax, pathMin);
        dfs(root.right, pathMax, pathMin);
        return;
    }
}
