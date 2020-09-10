import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        q.offer(root);
        List<Integer> line = new ArrayList<Integer>();
        int thisline = 1, nextline = 0;
        while (!q.isEmpty()) {
            TreeNode front = q.poll();

            line.add(front.val);
            if (front.left != null) {
                q.offer(front.left);
                nextline++;
            }
            if (front.right != null) {
                q.offer(front.right);
                nextline++;
            }
            thisline--;
            if (thisline == 0) {
                thisline = nextline;
                nextline = 0;
                result.add(line);
                line = new ArrayList<Integer>();
            }
        }
        return result;
    }
}
