public class Leetcode_865 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return height(root).node;
    }

    public Result height(TreeNode node)
    {
        if(node == null)
            return new Result(0,null);
        else
        {
            Result lResult = height(node.left),rResult = height(node.right);
            int lh = lResult.depth,rh = rResult.depth;
            if(lh == rh)
                return new Result(lh+1, node);
            else if(lh<rh)
                return new Result(rh+1, rResult.node);
            else
                return new Result(lh+1, lResult.node);
        }
    }

    class Result{
        public int depth;
        public TreeNode node;
        Result(int d,TreeNode n){depth = d;node = n;};
    }
}
