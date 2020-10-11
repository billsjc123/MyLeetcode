import java.util.HashSet;
import java.util.Set;

import javax.swing.tree.TreeNode;

public class Leetcode_1261 {
    Set <int>s = new HashSet<int>();
    public FindElements(TreeNode root) {
        root = rebulit(root, 0)
    }
    
    public boolean find(int target) {
        if(s.contains(target))return true;
        return false;
    }

    public TreeNode rebulit(TreeNode root, int val){
        root.val = val;
        s.add(val);
        if(root.left != null){
            root.left = rebulit(root.left, val*2+1);
        }
        if(root.right != null){
            root.right = rebulit(root.right, val*2+2);
        }
        return root;
    }
}
