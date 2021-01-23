import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_894 {
    Map<Integer,List<TreeNode>> memo = new HashMap<Integer,List<TreeNode>>();
    public List<TreeNode> allPossibleFBT(int N) {
        if(!memo.containsKey(N)){
            List<TreeNode> ans = new ArrayList<TreeNode>();
            if(N==1){
                ans.add(new TreeNode(0));
            }else if(N%2==1){
                for (int i = 0; i < N; i++) {
                    int l = i,r = N-1-i;
                    for (TreeNode lnode : allPossibleFBT(l)) {
                        for (TreeNode rnode : allPossibleFBT(r)) {
                            TreeNode root = new TreeNode(0);
                            root.left = lnode;
                            root.right = rnode;
                            ans.add(root);
                        }
                    }
                }
            }
            memo.put(N, ans);
        }
        return memo.get(N);
    }
}
