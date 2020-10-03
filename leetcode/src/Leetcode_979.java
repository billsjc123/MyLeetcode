public class Leetcode_979 {
    int result = 0;

    public int distributeCoins(TreeNode root){
        helper(root);
        return result;
    }
    // return <0 表示子树缺少金币， >0表示子树金币富裕
    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        int cur_coin = root.val - helper(root.left) - helper(root.right);
        result += Math.abs(1-cur_coin);
        return 1-cur_coin;
    }
}
