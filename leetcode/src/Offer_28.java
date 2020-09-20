public class Offer_28 {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    public boolean helper(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null)
            return true;
        // 根节点root
        if (leftNode == rightNode) {
            return helper(leftNode.left, leftNode.right);
        }
        // 只有一边是null或者两边值不相等
        if(leftNode == null || rightNode == null || leftNode.val!=rightNode.val)
            return false;
        return helper(leftNode.left, rightNode.right) && helper(leftNode.right, rightNode.left);
    }
}
