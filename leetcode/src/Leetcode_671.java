public class Leetcode_671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null)
            return -1;

        if (root.left.val == root.right.val) {
            int leftSec = findSecondMinimumValue(root.left),rightSec = findSecondMinimumValue(root.right);
            if (leftSec==-1||rightSec==-1)return Math.max(leftSec, rightSec);
            return Math.min(leftSec, rightSec);
        }

        TreeNode minNode, largerNode;
        if (root.left.val < root.right.val) {
            minNode = root.left;
            largerNode = root.right;
        } else {
            minNode = root.right;
            largerNode = root.left;
        }
        int secondMin = findSecondMinimumValue(minNode);
        if (secondMin < 0 || secondMin > largerNode.val) {
            return largerNode.val;
        } else
            return secondMin;
    }
}
