# 合法二叉搜索树的判定
对于合法的二叉搜索树，一定满足如下性质
1.  该节点左子树上的所有结点的值小于当前节点；右子树上所有结点的值大于当前节点
2.  二叉搜索树不能存在两个相等的节点（相等返回false）
3.  根据1可以推出，二叉搜索树的中序遍历是单调递增的序列

## 方法一：中序遍历
根据定理3可以得到，如果当前中序遍历的结果不是一个单调递增的序列，那么返回false，相反返回true。
但是在处理过程中并不需要保存整个序列，事实上只要知道上一个数是多少即可。（数学归纳法）
```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        Stack<Integer> stack = new Stack<Integer>();
        boolean result = inOrderTraverse(root, stack);
        return result;
    }
    public boolean inOrderTraverse(TreeNode node,Stack<Integer> stack)
    {
        if(node == null)
            return true;
        boolean leftchild = inOrderTraverse(node.left, stack);
        if(!leftchild)
            return false;
        if(!stack.isEmpty()&&stack.pop()>=node.val)
            return false;
        stack.push(node.val);
        boolean rightchild = inOrderTraverse(node.right, stack);
        if(!rightchild)
            return false;
        else
            return true;
    }
}
```
在此我利用了一个栈作为参数。每次判定就pop掉最上面的值。

## 方法二：记录最大值和最小值
在我第一次做这个题时遇到了一个错误，我的判断条件是：如果左子树和右子树是二叉搜索树且当前节点值大于左子树root值小于右子树root值，则返回true。
这个错误的原因是在于没有考虑到：左子树的root并非是左子树中最大的节点，右子树的root同理。因此要进行判断，必须将当前节点和左子树的最大节点进行判断。
对于这一点，其实可以使用逆向思维，如果当前节点大于左子树的最大节点，那么当前节点比左子树中的任意一个值都要大。那么如果左子树有一个值比这个“最大值”还要大，返回false即可。因此我在参数中记录下当前子树的“MIN”和“MAX”，并进行比较，解决了该题.
值得注意的是，该题有一个坑爹样例[2147483647]。如果使用int会溢出，因此我使用了Long。而int转Long使用Long.valueOf(int value)
```java
public class Interview_04_05 {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTree(TreeNode node, Long min, Long max) {
        if (node == null)
            return true;
        if (node.val <= min || node.val >= max)
            return false;
        Long nodeValue = Long.valueOf(node.val);
        return isValidBSTree(node.left, min, nodeValue) && isValidBSTree(node.right, nodeValue, max);
    }
}
```