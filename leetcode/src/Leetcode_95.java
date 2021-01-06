import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_95{
    public static void main(String[] args) {
        new sa().generateTrees(3);
    }
}
class sa {
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    List<TreeNode> dfs(int min, int max) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (min > max)
            return Arrays.asList(new TreeNode[]{null});
        if (min == max) {
            result.add(new TreeNode(min));
            return result;
        }
        for (int i = min; i <= max; i++) {
            List<TreeNode> llist = dfs(min, i - 1);
            List<TreeNode> rlist = dfs(i + 1, max);
            for (TreeNode rNode : rlist) {
                for (TreeNode lNode : llist) {
                    TreeNode root = new TreeNode(i);
                    root.left = lNode;
                    root.right = rNode;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
