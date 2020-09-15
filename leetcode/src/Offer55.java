
public class Offer55 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        return height(root)>=0;
    }

    public int height(TreeNode node) {
        if (node == null)
            return 0;
        int lh = height(node.left), rh = height(node.right);
        if (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1)
            return -1;
        return Math.max(lh,rh) + 1;
    }
}