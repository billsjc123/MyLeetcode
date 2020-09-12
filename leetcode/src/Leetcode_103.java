import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // one simple method is use LevelOrder and reverse every List of even layer.
        // this method use BFS and reverse the direction of push the node into stack every layer.
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        // 1 represent from left to right
        int order = 1;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            int size = stack.size();
            List<Integer> thislayer = new ArrayList<Integer>();
            // remember to create a new stack for next level
            Stack<TreeNode> nextLayerStack = new Stack<TreeNode>();

            // push nodes of next level into stack from left to right
            if(order==1)
            {
                for(int i = 0;i<size;i++)
                {
                    TreeNode node = stack.pop();
                    thislayer.add(node.val);
                    if(node.left!=null)
                        nextLayerStack.push(node.left);
                    if(node.right!=null)
                        nextLayerStack.push(node.right);
                }
                result.add(thislayer);
            }
            // push nodes of next level into stack from right to left
            else{
                for(int i = 0;i<size;i++)
                {
                    TreeNode node = stack.pop();
                    thislayer.add(node.val);
                    if(node.right!=null)
                        nextLayerStack.push(node.right);
                    if(node.left!=null)
                        nextLayerStack.push(node.left);
                }
                result.add(thislayer);
            }
            stack = nextLayerStack;
            order = 1-order;
        }
        return result;
    }
}
