public class Leetcode_98 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode node, Long min, Long max) {
        if (node == null)
            return true;
        if (node.val < max && node.val > min && helper(node.left, min, Long.valueOf(node.val)) && helper(node.right,  Long.valueOf(node.val), max))
            return true;
        else
            return false;
    }
}
