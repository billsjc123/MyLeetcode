# Leetcode 114.二叉树转为链表

> <a href="https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/">给定一颗二叉树，按照前序遍历的顺序将该二叉树**原地**转为一条单链表</a>

看到这题的常见思路一般都是如下：

## 方法一、前序遍历+节点记录

使用前序遍历，利用全局变量pre和cur记录前一个遍历到的节点，将节点的右子树设为当前节点，则可实现链表的原地转换。

但是该思路有一个陷阱——如果使用递归的算法，每次进行将pre的右子树修改为当前节点cur时，pre的右节点会丢失！

所以对于前序遍历，只能使用迭代的方法，利用栈“保存”每个节点，在遍历到它时再弹出。

```java
class Solution {
     public void flatten(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode dummy = new TreeNode(0);
        TreeNode prev =null,cur = dummy;
        s.push(root);
        while(!s.isEmpty())
        {
            prev =cur;
            cur = s.pop();
            prev.right = cur;
            prev.left = null;
            if(cur.right!=null)
                s.push(cur.right);
            if(cur.left!=null)
                s.push(cur.left);
        }
        root = dummy.right;
    }
}
```

## 方法二 后序遍历+节点记录

同上，因为单链表是使用右节点进行连接，因此使用递归会丢失右节点。为什么会丢失右节点呢？**因为使用前序遍历的时候，是先访问自己，再访问右节点，因此访问完自己之后，就会修改右节点，此时就会出现丢失**。那么针对这种情况，如果每次先访问右节点，再访问自己，就可以避开这个问题。

为了使顺序一致，使用后续遍历的访问顺序应该是前序遍历的reverse。因此后序遍历应该是先遍历右子树再遍历左子树。

使用全局变量pre，将pre记录为当前节点的下一个节点，每次访问时将该节点的右节点设为pre即可

```java
class Solution {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
```



