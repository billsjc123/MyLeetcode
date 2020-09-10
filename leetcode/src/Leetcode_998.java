import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


public class Leetcode_998 {
    public TreeNode insertIntoMaxTree(TreeNode root,int val) {
        if(root == null)
            return new TreeNode(val);
        // val在最后一个，因此只能在每个大于他的祖先节点的右子树
        // val在最后一个，因此每个小于他的子孙结点都在他左子树
        if(root.val>val)
        {
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
        else{
            TreeNode tmp = new TreeNode(val);
            tmp.left = root;
            return tmp;
        }
    }
    
    @Test
    public void test1()
    {
        TreeNode root = new TreeNode(0);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(3);

        System.out.println(root.val);
    }
}
