
public class Offer54 {
    int res,cnt;
    public int kthLargest(TreeNode root, int k) {
        cnt = k-1;
        inOrderTraverse(root);
        return res;
    }
    public void inOrderTraverse(TreeNode node)
    {
        if(node == null || cnt == -1)
            return;
        inOrderTraverse(node.right);
        if(cnt == 0)
            res = node.val;
        cnt--;
        inOrderTraverse(node.left);
    }
}
