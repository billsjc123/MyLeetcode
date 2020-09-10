import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Interview_04_03 {
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> result = new ArrayList<ListNode>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (tree == null)
            return result.toArray(new ListNode[]{});
        q.offer(tree);
        while (!q.isEmpty()) {
            int size = q.size();
            ListNode dummy = new ListNode(0),cur_node = dummy;
            for(int i = 0;i<size;i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                cur_node.next = new ListNode(node.val);
                cur_node = cur_node.next;
            }
            result.add(dummy.next);
            dummy.next = null;
        }
        return result.toArray(new ListNode[]{});
    }
}
