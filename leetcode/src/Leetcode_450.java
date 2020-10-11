
public class Leetcode_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        // step 1. find the key and its parent
        if(root.val > key)root.left = deleteNode(root.left, key);
        else if(root.val < key)root.right = deleteNode(root.right, key);
        else{
            if(root.left==null && root.right==null)return null;
            if(root.left!=null)
            {
                root.val = findClosetNode(root, true);
                root.left = deleteNode(root.left, root.val);
            }
            else{
                root.val = findClosetNode(root, false);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    public int findClosetNode(TreeNode node,boolean left) {
        TreeNode cNode;
        if(left==true){
            cNode = node.left;
            while(cNode.right!=null){
                cNode=cNode.right;
            }
        }else{
            cNode = node.right;
            while(cNode.right!=null){
                cNode=cNode.left;
            }
        }
        return cNode.val;
    }
}
