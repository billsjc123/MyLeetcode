import java.util.Stack;

import org.junit.Test;


public class Leetcode_114 {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
    @Test
    public void test()
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        flatten(root);
    }
}