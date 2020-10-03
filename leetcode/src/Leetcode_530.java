
public class Leetcode_530 {
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    public int getMinimumDifference(TreeNode root) {
        genList(root);
        return min;
    }

    public void genList(TreeNode root){
        if(root==null)return;
        genList(root.left);
        if(prev!=null)
        {
            Integer dif = Math.abs(prev-root.val);
            min = min<dif?min:dif;
        }
        prev=root.val;
        genList(root.right);
    }
}
