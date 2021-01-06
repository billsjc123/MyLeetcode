import java.util.Arrays;

class Leetcode_889 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0)
            return null;
        if (pre.length == 1)
            return new TreeNode(pre[0]);

        TreeNode root = new TreeNode(pre[0]);

        int lc = pre[1];
        int lcLast;
        for (lcLast = 0; lcLast < post.length; lcLast++) {
            if (post[lcLast] == lc)
                break;
        }
        int[] post_lTree = Arrays.copyOfRange(post, 0, lcLast + 1);
        int[] pre_lTree = Arrays.copyOfRange(pre, 1, post_lTree.length + 1);
        root.left = constructFromPrePost(pre_lTree, post_lTree);

        int[] post_rTree = Arrays.copyOfRange(post, lcLast + 1, post.length - 1);
        int[] pre_rTree = Arrays.copyOfRange(pre, post_lTree.length + 1, pre.length);
        root.right = constructFromPrePost(pre_rTree, post_rTree);

        return root;
    }
}