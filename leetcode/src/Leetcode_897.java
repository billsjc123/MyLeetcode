

public class Leetcode_897{
    TreeNode cur_node;
    public TreeNode increasingBST(TreeNode root) {
          TreeNode newroot = new TreeNode(0);
          cur_node = newroot;
          traverse(root);
          return newroot.right;  
    }
    void traverse(TreeNode node)
    {
        if(node == null)
            return;
        traverse(node.left);
        cur_node.right = new TreeNode(node.val);
        cur_node = cur_node.right;
        traverse(node.right);
    }
}