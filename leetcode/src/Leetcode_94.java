import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        // recursive
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur_node = root;
        while (cur_node != null || !stack.isEmpty()) {
            while (cur_node != null) {
                stack.push(cur_node);
                cur_node = cur_node.left;
            }
            cur_node = stack.pop();
            list.add(cur_node.val);
            cur_node = cur_node.right;
        }
        return list;
    }

}
