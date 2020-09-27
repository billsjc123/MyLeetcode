import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_113 {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        dfs(root, sum, 0, new Stack<Integer>());
        return result;
    }

    public void dfs(TreeNode node, int target, int cur_sum, Stack<Integer> path) {
        path.push(node.val);
        cur_sum += node.val;
        if (node.left == null && node.right == null) {
            if (cur_sum == target) {
                List<Integer> r = new ArrayList<Integer>(path);
                result.add(r);
            }
            path.pop();
            return;
        }
        if (node.left != null)
            dfs(node.left, target, cur_sum, path);
        if (node.right != null)
            dfs(node.right, target, cur_sum, path);
        path.pop();
    }
}
