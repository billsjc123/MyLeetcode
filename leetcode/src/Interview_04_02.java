public class Interview_04_02 {
    int result;
    int target;

    public int pathSum(TreeNode root, int sum) {
        result = 0;
        target = sum;
        int[] paths = new int[depth(root)];
        pathSum(root, 0, paths);
        return result;
    }

    public int depth(TreeNode root)
    {
        if(root == null)
            return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }

    public void pathSum(TreeNode node,int depth,int[] paths)
    {
        if(node == null)
            return;
        paths[depth]=node.val;
        int sum = 0;
        for(int i=0;i<=depth;i++)
        {
            sum+=paths[i];
            if(sum == target)
                result++;
        }
        pathSum(node.left, depth+1, paths);
        pathSum(node.right, depth+1, paths);
    }

    public void preOrderTraverse(TreeNode node)
    {
        if(node == null)
            return;
        fromUptoButtom(node, 0);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    public void fromUptoButtom(TreeNode root, int cur_sum) {
        if (root == null)
            return;
        if (cur_sum + root.val == target) {
            result++;
        }
        fromUptoButtom(root.left, cur_sum + root.val);
        fromUptoButtom(root.right, cur_sum + root.val);
    }


}
