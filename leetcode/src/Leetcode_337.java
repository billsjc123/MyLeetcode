import org.junit.Test;

public class Leetcode_337 {
    int ans = 0;
    public int rob(TreeNode root) {
        dfs(root,root.val,true);
        dfs(root,0,false);
        return ans;
    }

    public int dfs(TreeNode node,int sum,boolean isStolen){
        if(node == null)return 0;

        if(isStolen){
            int left = dfs(node.left,sum,false);
            int right = dfs(node.right,sum,false);
            ans = Math.max(ans,sum+left+right);
            return left+right;
        }else{
            int left = dfs(node.left,sum+node.val,true);
            int right = dfs(node.right,sum+node.val,true);
            ans = Math.max(ans,sum+left+right+node.val);
            return node.val+left+right;
        }
    }

}
