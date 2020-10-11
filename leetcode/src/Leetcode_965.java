
public class Leetcode_965 {
    public boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        return dfs(root, val);
    }

    public boolean dfs(TreeNode node, int val) {
        if(node == null)return true;
        return val == node.val && dfs(node.left, val) && dfs(node.right, val);
    }
}
