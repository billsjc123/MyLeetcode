public class Interview_04_10 {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        else if (t1 == null || t2 == null)
            return false;

        if (t1.val != t2.val)
            return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
        else {
            if (isSameTree(t1, t2))
                return true;
            else
                return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
        }
    }

    public boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        else if (t1 == null || t2 == null)
            return false;

        if (t1.val == t2.val)
            return checkSubTree(t1.left, t2.left) && checkSubTree(t1.right, t2.right);
        else
            return false;
    }
}
