# 求和路径

先看看题目，这题理解题目还是比较重要的：

给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，**路径不一定非得从二叉树的根节点或叶节点开始或结束**，但是其方向必须向下(只能从父节点指向子节点方向)。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

3
解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
提示：

节点总数 <= 10000

首先，这题的易错点是：
1.  不一定得从根开始或叶子节点结束
2.  节点值可正可负，因此不能修枝

接下来讲讲我的思路：

## 两遍DFS
我一开始的思路非常简单，自顶向下，以每个节点为出发点向下寻找。这样不仅要DFS一遍二叉树以遍历每一个出发点，还要在DFS中再进行一次DFS获取sum值。这种做法的比较简单好想，但很明显，进行了大量的重复计算，速度很慢。
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int result;
    int target;

    public int pathSum(TreeNode root, int sum) {
        result = 0;
        target = sum;
        preOrderTraverse(root);
        return result;
    }

    public void preOrderTraverse(TreeNode node)
    {
        if(node == null)
            return;
        fromUptoButtom(node, 0);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    public void fromUptoButtom(TreeNode root, int cur_sum) {
        if (root == null)
            return;
        if (cur_sum + root.val == target) {
            result++;
        }
        fromUptoButtom(root.left, cur_sum + root.val);
        fromUptoButtom(root.right, cur_sum + root.val);
    }
}
```
代码很简单，注意别乱修枝就行！！

## 一遍DFS
第二种做法是看了题解得来的，感觉十分巧妙。先贴代码：
```java
class Solution {
    int result;
    int target;

    public int pathSum(TreeNode root, int sum) {
        result = 0;
        target = sum;
        int[] paths = new int[depth(root)];
        pathSum(root, 0, paths);
        return result;
    }

    public int depth(TreeNode root)
    {
        if(root == null)
            return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }

    public void pathSum(TreeNode node,int depth,int[] paths)
    {
        if(node == null)
            return;
        paths[depth]=node.val;
        int sum = 0;
        // very important
        for(int i=depth;i>=0;i--)
        {
            sum+=paths[i];
            if(sum == target)
                result++;
        }
        pathSum(node.left, depth+1, paths);
        pathSum(node.right, depth+1, paths);
    }
}
```
首先是聪明的利用了Java传参中的引用传递，这点是我一开始看着题没想到的。因为是引用传递，因此对于每个节点来说，`paths`只存储了从根节点到当前节点路径上的所有值。这种传参方法我感觉可以推广到其他二叉树的题，值得学习。
其次，我一开始复现该方法时，以为自己懂了，for循环使用了`for(int i = 0;i<=depth;i++)`。很明显这题不能正向遍历，这样的话不但会重复得到一些答案，并且每次得到的答案都是从根节点出发的，与题目条件不符。之所以反向遍历，是为了不得到重复的答案，并且保证每一种组合都被讨论到。

![image-20200916221413470](C:\Users\10343\AppData\Roaming\Typora\typora-user-images\image-20200916221413470.png)

如同该数，以右子树为例，假设当前节点是-2，那么依次讨论[-2],[-3,-2],[1,-3,-2]。为什么不讨论[1,-3]呢？因为在上一次递归已经讨论过了。