import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode_1110 {
    List<TreeNode> result;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        result = new ArrayList<TreeNode>();
        result.add(root);
        if (root == null)
            return result;
        for (int i = 0; i < to_delete.length; i++) {
            map.put(to_delete[i], 1);
        }
        traverse(root, null,0,map);
        return result;
    }

    public void traverse(TreeNode node, TreeNode parent, int side, HashMap<Integer, Integer> map) {
        if (node == null)
            return;
        TreeNode lc = node.left, rc = node.right;
        TreeNode cur_parent = node;
        if (map.containsKey(node.val)) {
            if (node.left != null)
                result.add(node.left);
            if (node.right != null)
                result.add(node.right);
            map.remove(node.val);
            if(parent != null)
            {
                if (side == 0)
                    parent.left = null;
                else
                    parent.right = null;
            }
            else
            {
                for (int i = 0; i < result.size(); i++) {
                    if(result.get(i).val==node.val)
                    {
                        result.remove(i);
                        break;
                    }
                }
            }
            cur_parent = null;
        }
        traverse(lc, cur_parent, 0, map);
        traverse(rc, cur_parent, 1, map);
    }
}
