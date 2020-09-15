import java.util.Stack;

public class Interview_04_05 {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTree(TreeNode node, Long min, Long max) {
        if (node == null)
            return true;
        if (node.val <= min || node.val >= max)
            return false;
        Long nodeValue = Long.valueOf(node.val);
        return isValidBSTree(node.left, min, nodeValue) && isValidBSTree(node.right, nodeValue, max);
    }
}
