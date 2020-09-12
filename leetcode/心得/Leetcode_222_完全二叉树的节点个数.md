# 完全二叉树的节点个数

## 普适方法

对于求二叉树的结点的问题，第一眼都会想到普适方法

```java
public int cntNodes(TreeNode node)
{
    if(node == null)
        return 0;
    return cntNodes(node.left)+cntNode(cnt.right)+1;
}
```

但是这种方法没有用到完全二叉树的性质

## 完全二叉树的解法——二分查找

对于一株完全二叉树，存在两种情况：

- 满二叉树：这种情况得到树的深度就可以直接计算出结果
- 不满的二叉树：这种情况，需要找到最后一层的最后一个结点的位置。

​		因此本题的关键就在于找到最后一个结点的位置。那么如何利用完全二叉树的特性呢？利用二分查找的思想——对于每一个根节点，如果该根节点产生的树不是满二叉树，那么最后一个根节点不是在左子树就是在右子树。

​		对于根节点1来说，最后一个结点在左子树，因此右子树肯定是个满二叉树，可以直接计算出右子树的结点数；对于结点2来说，最后一个结点在右子树，因此左子树一定是满二叉树，因此可以直接计算左子树的结点数。这样，只要判断了最后一个结点的位置，就可以立即算出一半的结点数。**这就是二分查找的思想**。

![image-20200912111959533](C:\Users\10343\AppData\Roaming\Typora\typora-user-images\image-20200912111959533.png)

​		那么如何知道最后一个节点在左边还是右边？比较左子树和右子树的最左叶子节点的高度即可。设左边的高度为hLeft，右边的高度为hRight

- hLeft==hRight：可能是满二叉树，反正最后一个节点肯定在右子树，因此可以直接算出左子树的结点数
- hLeft!=hRight：不可能是满二叉树，最后一个节点肯定在左子树

运用这个递归的思想，不断的计算左子树或右子树的结点，即可得到结点个数。

```java
public class Leetcode_222 {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(leftHeight==rightHeight)
            return (1<<leftHeight)+countNodes(root.right);
        else
            return (1<<rightHeight)+countNodes(root.left);
    }
    public int height(TreeNode root)
    {
        int h = 0;
        while(root!=null)
        {
            root = root.left;
            h++;
        }
        return h;
    }
}
```

