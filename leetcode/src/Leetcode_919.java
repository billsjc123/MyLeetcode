import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class Leetcode_919 {
    TreeNode root;
    Queue<TreeNode> insertQueue;
    public Leetcode_919(TreeNode root) {
        this.root = root;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        insertQueue = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
                if(node.left==null || node.right==null)insertQueue.offer(node);
            }
        }
    }
    
    public int insert(int v) {
        TreeNode parent = insertQueue.peek();
        if(parent.left==null){
            parent.left = new TreeNode(v);
            insertQueue.offer(parent.left);
        }
        else{
            parent.right = new TreeNode(v);
            insertQueue.poll();
            insertQueue.offer(parent.right);
        }
        return parent.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
    @Test
    public void test()
    {
        TreeNode root = new TreeNode(1);
        Leetcode_919 solution = new Leetcode_919(root);
        solution.insert(2);
    }
}
