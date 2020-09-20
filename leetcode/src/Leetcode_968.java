public class Leetcode_968 {
    int result = 0;

    public int minCameraCover(TreeNode root) {
        if(dfs(root)==0)result++;
        return result;
    }

    /*
     * returnVal: - 0: leaf - 1: a parent of leaf which has a camera - 2: covered
     * but without a camera
     */
    public int dfs(TreeNode node) {
        if (node == null)
            return 2;
        int l = dfs(node.left), r = dfs(node.right);
        if (l * r == 0) {
            result++;
            return 1;
        }
        if(l == 1 || r == 1){
            return 2;
        }
        // if(l==2 && r == 2) -- leaf
        return 0;
    }
}
