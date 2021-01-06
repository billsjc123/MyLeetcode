import java.util.HashMap;

public class Leetcode_993 {
    HashMap<Integer,Integer> parent = new HashMap<Integer,Integer>();
    HashMap<Integer,Integer> depth = new HashMap<Integer,Integer>();

    public boolean isCousins(TreeNode root, int x, int y) {

        dfs(root, 1);
        if (depth.get(x)==depth.get(y) && parent.get(x)!=parent.get(y)){
            return true;
        }
        return false;
    }

    void dfs(TreeNode root,int cur_depth){
        depth.put(root.val, cur_depth);
        if (root.left!=null){
            parent.put(root.left.val,root.val);
            dfs(root.left,cur_depth+1);
        }
        if (root.right!=null){
            parent.put(root.right.val,root.val);
            dfs(root.right,cur_depth+1);
        }
    }
}
