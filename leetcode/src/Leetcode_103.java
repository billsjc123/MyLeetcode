import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root==null)return ans;
        
        LinkedList<TreeNode> deque = new LinkedList<TreeNode>();
        deque.addLast(root);
        boolean oddLayer = true;
        while(!deque.isEmpty()){
            int size = deque.size();
            ArrayList<Integer> layer = new ArrayList<Integer>();
            if(oddLayer){
                for(int i=0;i<size;i++){
                    TreeNode temp = deque.removeFirst();
                    layer.add(temp.val);
                    if(temp.left!=null)deque.addLast(temp.left);
                    if(temp.right!=null)deque.addLast(temp.right);
                }
            }else{
                for(int i=0;i<size;i++){
                    TreeNode temp = deque.removeLast();
                    layer.add(temp.val);
                    if(temp.right!=null)deque.addFirst(temp.right);
                    if(temp.left!=null)deque.addFirst(temp.left);
                }
            }
            ans.add(layer);
            oddLayer=!oddLayer;
        }
        return ans;
    }
}
