# 二叉树Z字形遍历

## 栈
我一开始的想法：利用队列或者栈。队列发现行不通，使用栈的时候，发现可以根据从左到右子树入栈的顺序来改变遍历的顺序。
虽然改变顺序每层入栈的顺序都是正确的，但我忽视了新入栈的元素会在旧入栈的元素的上面，导致答案错误。因此每层需要用一个新的Stack来存下一层的信息。
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

## 双端队列
这题的正确思路应该是层序遍历+双端队列。有了双端队列自己只需知道那一层从头插那一层从尾插即可。
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