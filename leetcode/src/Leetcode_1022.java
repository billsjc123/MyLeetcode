public class Leetcode_1022{
    int sum;
    final int model = (int) (Math.pow(10, 9) + 7);
    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        if(root == null)
            return sum;
        int []paths  = new int[depth(root)];
        pathSum(root, 0, paths);
        return sum;
    }
    public void pathSum(TreeNode node,int depth,int[] paths)
    {
        paths[depth] = node.val;
        if(node .left==null && node.right == null)
        {
            int cur_sum = 0;
            for (int i = 0; i <= depth; i++) {
                cur_sum = (2*cur_sum+paths[i])%model;
            }
            sum = (sum+cur_sum)%model;
            return;
        }
        pathSum(node.left, depth+1, paths);
        pathSum(node.right, depth+1, paths);
    }
    public int depth(TreeNode root)
    {
        if(root == null)
            return 0;
        return Math.max(depth(root.left), depth(root.right))+1;
    }
}