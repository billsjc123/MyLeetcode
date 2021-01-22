import java.util.HashMap;

import org.junit.Test;

public class Leetcode_106 {
    HashMap<Integer, Integer> in_map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            in_map.put(inorder[i], i);
        }
        if (inorder.length == 0)
            return null;
        else if (inorder.length == 1)
            return new TreeNode(inorder[0]);
        else
            return helper(inorder, postorder, 0, inorder.length - 1, inorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int l, int r, int root_post_idx) {
        if (l == r)
            return new TreeNode(inorder[l]);
        if (l > r)
            return null;

        int root_val = postorder[root_post_idx];
        int root_idx = in_map.get(root_val);
        TreeNode root = new TreeNode(root_val);

        int r_length = r - root_idx;

        root.left = helper(inorder, postorder, l, root_idx - 1, root_post_idx - 1 - r_length);
        root.right = helper(inorder, postorder, root_idx + 1, r, root_post_idx - 1);
        return root;
    }

    @Test
    public void test1() {
        buildTree(new int[] { 1, 2, 3, 4, 5 }, new int[] { 2, 1, 5, 4, 3 });
    }
}
