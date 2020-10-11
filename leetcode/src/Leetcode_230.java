import java.util.Stack;

public class Leetcode_230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        int result = 0;
        TreeNode l = root;
        while(l!=null){
            s.push(l);
            l = l.left;
        }
        for (int i = 0; i < k; i++) {
            TreeNode node = s.pop();
            result = node.val;
            if(node.right!=null){
                TreeNode lc = node.right;
                while(lc!=null){
                    s.push(lc);
                    lc = lc.left;
                }
            }
        }
        return result;
    }
}
