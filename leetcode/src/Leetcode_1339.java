import java.util.ArrayList;
import java.util.List;


public class Leetcode_1339 {
    class helper{
        public boolean lleaf,rleaf;
        public Long lsum,rsum;
        public helper(Long l,Long r){
            lsum = l;
            rsum=r;
        }
    }
    List<helper> nodelist;
    public int maxProduct(TreeNode root) {
        if(root == null)return 0;
        nodelist = new ArrayList<helper>();
        dfs(root);
        helper rootinfo = nodelist.get(nodelist.size()-1);
        Long total_sum = rootinfo.lsum + rootinfo.rsum + root.val;
        Long max = Long.MIN_VALUE;
        for (helper node : nodelist) {
            if(!node.lleaf)
            {
                Long product = (node.lsum * (total_sum-node.lsum));
                max = max < product?product:max;
            }
            if(!node.rleaf)
            {
                Long product = node.rsum * (total_sum-node.rsum);
                max = max < product?product:max;
            }
        }
        return (int)(max % (int)(1e9 + 7));
    }

    public long dfs(TreeNode node)
    {
        if(node == null)return 0L;
        long l = dfs(node.left),r = dfs(node.right);
        helper h = new helper(l, r);
        h.lleaf = node.left==null?true:false;
        h.rleaf = node.right==null?true:false;
        nodelist.add(h);
        return node.val+l+r;
    }
}
