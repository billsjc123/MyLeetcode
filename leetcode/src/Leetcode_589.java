import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class Leetcode_589 {
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(final int _val) {
            val = _val;
        }
    
        public Node(final int _val, final List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        Stack<Node> s = new Stack<Node>();
        s.push(root);
        while(!s.empty())
        {
            Node top = s.pop();
            result.add(top.val);
            for(int i = top.children.size()-1;i>=0;i--)
            {
                s.push(top.children.get(i));
            }
        }
        return result;
    }
}
