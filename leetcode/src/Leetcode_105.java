import java.util.HashMap;

public class Leetcode_105 {
    HashMap<Integer, Integer> in_map = new HashMap<Integer, Integer>();
    int preLeft = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            in_map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);
    }
    public TreeNode helper(int[] preorder,int []inorder,int inLeft,int inRight){
        if(inLeft>inRight)return null;
        else if (inLeft==inRight)return new TreeNode(inorder[inLeft]);

        int root_val = inorder[preLeft];
        int root_idx_in = in_map.get(root_val);
        TreeNode root = new TreeNode(root_val);
        
        preLeft++;

        root.left = helper(preorder, inorder, inLeft, root_idx_in-1);
        root.right = helper(preorder, inorder,root_idx_in-1,inRight);
        return root;
    }
    // public TreeNode helper(int[] preorder,int []inorder,int preLeft,int inLeft,int inRight)
    // {
    //     if(inLeft>inRight || preLeft>=preorder.length)
    //         return null;
    //     if(inLeft==inRight)
    //         return new TreeNode(inorder[inLeft]);
    //     TreeNode node = new TreeNode(preorder[preLeft]);
    //     // 在中序中找到根节点
    //     int newRoot = -1;
    //     for (int i = inLeft;i<=inRight;i++) {
    //         if(inorder[i]==preorder[preLeft])
    //         {
    //             newRoot = i;
    //             break;
    //         }
    //     }
    //     node.left = helper(preorder, inorder, preLeft+1, inLeft, newRoot-1);
    //     node.right = helper(preorder, inorder, preLeft+(newRoot-inLeft)+1, newRoot+1, inRight);
    //     return node;
    // }
}
