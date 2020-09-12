public class Leetcode_222 {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(leftHeight==rightHeight)
            return (1<<leftHeight)+countNodes(root.right);
        else
            return (1<<rightHeight)+countNodes(root.left);
    }
    public int height(TreeNode root)
    {
        int h = 0;
        while(root!=null)
        {
            root = root.left;
            h++;
        }
        return h;
    }
}
