# ������Z���α���

## ջ
��һ��ʼ���뷨�����ö��л���ջ�����з����в�ͨ��ʹ��ջ��ʱ�򣬷��ֿ��Ը��ݴ�����������ջ��˳�����ı������˳��
��Ȼ�ı�˳��ÿ����ջ��˳������ȷ�ģ����Һ���������ջ��Ԫ�ػ��ھ���ջ��Ԫ�ص����棬���´𰸴������ÿ����Ҫ��һ���µ�Stack������һ�����Ϣ��
```java
class Solution {
   public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null)
            return result;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        boolean from_right = false;
        while (!s.isEmpty()) {
            List<Integer> l = new LinkedList<Integer>();
            int size = s.size();
            Stack<TreeNode> news = new Stack<TreeNode>();
            for (int i = 0; i < size; i++) {
                TreeNode node = s.pop();
                l.add(node.val);
                if (from_right) {
                    if (node.right != null)
                        news.push(node.right);
                    if (node.left != null)
                        news.push(node.left);
                } else {
                    if (node.left != null)
                        news.push(node.left);
                    if (node.right != null)
                        news.push(node.right);
                }
            }
            s = news;
            from_right = !from_right;
            result.add(l);
        }
        return result;
    }
}
```

## ˫�˶���
�������ȷ˼·Ӧ���ǲ������+˫�˶��С�����˫�˶����Լ�ֻ��֪����һ���ͷ����һ���β�弴�ɡ�
```java
public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        boolean fromfront = false;
        q.offer(root);
        while(!q.isEmpty()){
            LinkedList<Integer> tmp = new LinkedList<Integer>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(fromfront)tmp.addFirst(node.val);
                else tmp.addLast(node.val);
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
            }
            result.add(tmp);
            fromfront = !fromfront;
        }
        return result;
    }
```