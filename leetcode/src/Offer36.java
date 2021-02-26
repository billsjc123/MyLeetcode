import java.util.Stack;

public class Offer36 {
    class Node {
        public int val;
        public Node left;
        public Node right;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    public Node treeToDoublyList(Node root) {
        if(root==null)return null;
        Stack<Node> s = new Stack<Node>();
        Node dummy=new Node(0,null,root);

        // 保证dummy.right是最小的Node
        while(dummy.right!=null){
            s.push(dummy.right);
            dummy.right=dummy.right.left;
        }

        Node prev=null,cur=dummy;
        while(!s.isEmpty()){
            prev = cur;
            cur = s.pop();
            prev.right=cur;
            cur.left=prev;
            if(cur.right!=null){
                Node temp = cur.right;
                while(temp!=null){
                    s.push(temp);
                    temp=temp.left;
                }
            }
        }

        // 链接头和尾
        Node head = dummy.right;
        head.left=cur;
        cur.right=head;

        return dummy.right;
    }
}
