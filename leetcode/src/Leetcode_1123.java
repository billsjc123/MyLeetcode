import org.junit.Test;

public class Leetcode_1123 {
    TreeNode lca = null;
    int lca_depth = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null)return root;
        int height =depth(root);
        helper(root,0,height-1);
        return lca;
    }

    public int helper(TreeNode node,int cur_dep,int max_dep)
    {
        if(node==null)return cur_dep-1;
        int l = helper(node.left, cur_dep+1, max_dep);
        int r = helper(node.right, cur_dep+1, max_dep);
        if(l == max_dep && r == max_dep)
        {
            lca = node;
            return l;
        }
        return Math.max(l, r);
    }

    public int depth(TreeNode node)
    {
        if(node == null)
            return 0;
        return Math.max(depth(node.left), depth(node.right))+1;
    }
    @Test
    public void test()
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        lcaDeepestLeaves(root);
    }

}
