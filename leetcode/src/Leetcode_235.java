public class Leetcode_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<q.val) return helper(root, p.val, q.val);
        else return helper(root,q.val,p.val);
    }
    public TreeNode helper(TreeNode node,int l,int r)
    {
        if(node.val<l) return helper(node.right, l, r);
        else if(node.val>r) return helper(node.left, l, r);
        else  return node;
    }
}
