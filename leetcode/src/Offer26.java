public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        if (A.val == B.val)
            return traverse(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        else
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    public boolean traverse(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        else if (A == null && B != null)
            return false;
        return (A.val == B.val) && traverse(A.left, B.left) && traverse(A.right, B.right);
    }
}
