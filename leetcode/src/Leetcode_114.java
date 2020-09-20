import java.util.Stack;

import org.junit.Test;


public class Leetcode_114 {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode dummy = new TreeNode(0);
        TreeNode prev =null,cur = dummy;
        s.push(root);
        while(!s.isEmpty())
        {
            prev =cur;
            cur = s.pop();
            prev.right = cur;
            prev.left = null;
            if(cur.right!=null)
                s.push(cur.right);
            if(cur.left!=null)
                s.push(cur.left);
        }
        root = dummy.right;
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