public class Leetcode_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode lc = root.left,rc = root.right;
        if(lc==null && rc == null)
            return root;
        
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }
}
