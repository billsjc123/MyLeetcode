import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer> ();
        if(root == null)return result;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty())
        {
            TreeNode node = s.pop();
            result.add(node.val);
            if(node.right!=null)s.push(node.right);
            if(node.left!=null)s.push(node.left);
        }
        return result;
    }
}
