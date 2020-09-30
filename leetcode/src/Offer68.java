public class Offer68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return root;
        int n1 = p.val,n2 = q.val;
        return helper(root, Math.min(n1,n2),Math.max(n1, n2));
    }
    public TreeNode helper(TreeNode node,int min,int max)
    {
        if(node.val>max)return helper(node.left, min, max);
        else if(node.val<min)return helper(node.right, min, max);
        return node;
    }
}
