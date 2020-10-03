import java.util.HashMap;
import java.util.Iterator;

public class Leetcode_1457 {
    int result = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        dfs(root, map);
        return result;
    }

    public void dfs(TreeNode node, HashMap<Integer, Integer> map) {
        if (node == null) {
            Iterator<Integer> iter = map.keySet().iterator();
            boolean singleOdd = true;
            while (iter.hasNext()) {
                Integer key = iter.next();
                if (map.get(key) % 2 == 1) {
                    if (singleOdd == true)
                        singleOdd = false;
                    else if (singleOdd == false)
                        return;
                }
            }
            result++;
            return;
        } else {
            Integer ori_val;
            if (map.containsKey(node.val)) {
                ori_val = map.get(node.val);
            } else {
                ori_val = 0;
            }
            map.put(node.val, ori_val + 1);
            if (node.left == null && node.right == null)
                dfs(node.left, map);
            else {
                if (node.left != null)
                    dfs(node.left, map);
                if (node.right != null)
                    dfs(node.right, map);
            }
            map.put(node.val, ori_val);
        }
    }
}
