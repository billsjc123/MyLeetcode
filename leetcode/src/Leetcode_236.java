public class Leetcode_236 {
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null)return null;
        helper(root, p, q);
        return result;
    }
    public int helper(TreeNode node,TreeNode p,TreeNode q)
    {
        if(result!=null || node == null)return 0;
        int l = helper(node.left, p, q),r=helper(node.right, p, q);
        if(l+r==3)
        {
            result=node;
            return 0;
        }
        else if(node.val==p.val)
        {
            if(l!=2 && r!=2)
                return 1;
            result=node;
            return 0;
        }
        else if(node.val==q.val)
        {
            if(l!=1 && r!=1)
                return 2;
            result=node;
            return 0;
        }
        else return l+r;
    }
}