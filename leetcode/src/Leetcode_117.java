
public class Leetcode_117 {
    // 空间不是常数级别
    // public Node connect(Node root) {
    // if(root == null)return null;
    // Queue<Node> q = new LinkedList<Node>();
    // q.add(root);
    // while(!q.isEmpty())
    // {
    // int size = q.size();
    // for (int i = 0; i < size; i++) {
    // Node cur_node = q.poll();
    // if(i<size-1)cur_node.next = q.peek();
    // if(cur_node.left!=null)q.add(cur_node.left);
    // if(cur_node.right!=null)q.add(cur_node.right);
    // }
    // }
    // return root;
    // }

    // 空间常数级别
    Node last;
    Node startNode;

    public Node connect(Node root) {
        if (root == null)
            return root;
        Node start = root;
        while (start != null) {
            last = null;
            startNode = null;
            for (Node n = start; n != null; n = n.next) {
                if (n.left != null)
                    helper(n.left);
                if (n.right != null)
                    helper(n.right);
            }
            start = startNode;
        }
        return root;
    }

    public void helper(Node node) {
        if (last != null)
            last.next = node;
        if (startNode == null)
            startNode = node;
        last = node;
    }
}
