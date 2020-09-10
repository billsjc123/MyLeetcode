import java.util.ArrayList;
import java.util.List;

public class Leetcode_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        //recursive
        List<Integer> list = new ArrayList<Integer>();
        traverse(root, list);
        return list;
    }
    public void traverse(TreeNode node,List<Integer> list)
    {
        if(node == null)
            return;
        traverse(node.left, list);
        list.add(node.val);
        traverse(node.right, list);
    }
    
}
