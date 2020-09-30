import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


// class Node {
//     public int val;
//     public List<Node> children;

//     public Node() {}

//     public Node(final int _val) {
//         val = _val;
//     }

//     public Node(final int _val, final List<Node> _children) {
//         val = _val;
//         children = _children;
//     }
// }

class Solution {
    
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

public class Leetcode_589{
    public static void main(String[] args) {
        List<Node> list = new ArrayList<Node>();
        list.add(new Node(3));
        list.add(new Node(2));
        list.add(new Node(4));

        Node root = new Node(1,list);
        List<Node> list2 = new ArrayList<Node>();
        list2.add(new Node(5));
        list2.add(new Node(6));

        Node n = root.children.get(0);
        n.children = list2;
        Solution s = new Solution();
        List<Integer> result = s.preorder(root);
        System.out.println(result);

    }
}