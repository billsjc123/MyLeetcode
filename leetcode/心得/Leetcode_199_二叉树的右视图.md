# 二叉树的右视图

> 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

## DFS
看到这题我第一眼的想法是DFS，即每次顺着最右边的路径进行查找，并记录查找到的深度。如果最右边到底了，则返回上一节点的左子树继续类似的操作。
对于记录已经探索的最深的深度，直接使用result数组的大小即可，因为探了多深就有多少个元素。

## BFS
看了题解之后，发现了另外一种做法。既然是要求输出右视图，实际上是输出每一层的最右边的元素，实际上可以等价于层次遍历，只是只保留最右边的节点即可
```java
public class Leetcode_199 {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)return result;
        bfs(root);
        return result;
    }

    public void bfs(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(i==0){
                    result.add(node.val);
                }
                if(node.right!=null)q.add(node.right);
                if(node.left!=null)q.add(node.left);
            }
        }
    }

    public void dfs(TreeNode node, int curDepth){
        if(node == null)
            return ;
        if(curDepth>result.size())
        {
            result.add(node.val);
        }
        dfs(node.right, curDepth+1);
        dfs(node.left, curDepth+1);
    }
}
```