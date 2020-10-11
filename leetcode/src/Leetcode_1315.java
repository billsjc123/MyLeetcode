public class Leetcode_1315 {
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, false, false);
    }

    public int dfs(TreeNode node, boolean father, boolean grandpa) {
        if (node == null)
            return 0;
        boolean even = node.val % 2 == 0 ? true : false;
        if (grandpa)
            return node.val + dfs(node.left, even, father) + dfs(node.right, even, father);
        else
            return dfs(node.left, even, father) + dfs(node.right, even, father);
    }
}
