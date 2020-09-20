public class Leetcode_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length-1);
    }
    public TreeNode helper(int[] preorder,int []inorder,int preLeft,int inLeft,int inRight)
    {
        if(inLeft>inRight || preLeft>=preorder.length)
            return null;
        if(inLeft==inRight)
            return new TreeNode(inorder[inLeft]);
        TreeNode node = new TreeNode(preorder[preLeft]);
        // 在中序中找到根节点
        int newRoot = -1;
        for (int i = inLeft;i<=inRight;i++) {
            if(inorder[i]==preorder[preLeft])
            {
                newRoot = i;
                break;
            }
        }
        node.left = helper(preorder, inorder, preLeft+1, inLeft, newRoot-1);
        node.right = helper(preorder, inorder, preLeft+(newRoot-inLeft)+1, newRoot+1, inRight);
        return node;
    }
}
