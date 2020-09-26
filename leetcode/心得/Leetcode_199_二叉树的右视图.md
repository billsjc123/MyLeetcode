# ������������ͼ

> ����һ�ö������������Լ�վ�������Ҳ࣬���մӶ������ײ���˳�򣬷��ش��Ҳ����ܿ����Ľڵ�ֵ��

## DFS
���������ҵ�һ�۵��뷨��DFS����ÿ��˳�����ұߵ�·�����в��ң�����¼���ҵ�����ȡ�������ұߵ����ˣ��򷵻���һ�ڵ���������������ƵĲ�����
���ڼ�¼�Ѿ�̽�����������ȣ�ֱ��ʹ��result����Ĵ�С���ɣ���Ϊ̽�˶�����ж��ٸ�Ԫ�ء�

## BFS
�������֮�󣬷���������һ����������Ȼ��Ҫ���������ͼ��ʵ���������ÿһ������ұߵ�Ԫ�أ�ʵ���Ͽ��Եȼ��ڲ�α�����ֻ��ֻ�������ұߵĽڵ㼴��
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