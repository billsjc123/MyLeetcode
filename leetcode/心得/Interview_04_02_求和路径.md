# ���·��

�ȿ�����Ŀ�����������Ŀ���ǱȽ���Ҫ�ģ�

����һ�ö�����������ÿ���ڵ㶼����һ��������ֵ(��ֵ������)�����һ���㷨����ӡ�ڵ���ֵ�ܺ͵���ĳ������ֵ������·����������ע�⣬**·����һ���ǵôӶ������ĸ��ڵ��Ҷ�ڵ㿪ʼ�����**�������䷽���������(ֻ�ܴӸ��ڵ�ָ���ӽڵ㷽��)��

ʾ��:
�������¶��������Լ�Ŀ��� sum = 22��

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
����:

3
���ͣ���Ϊ 22 ��·���У�[5,4,11,2], [5,8,4,5], [4,11,7]
��ʾ��

�ڵ����� <= 10000

���ȣ�������״���ǣ�
1.  ��һ���ôӸ���ʼ��Ҷ�ӽڵ����
2.  �ڵ�ֵ�����ɸ�����˲�����֦

�����������ҵ�˼·��

## ����DFS
��һ��ʼ��˼·�ǳ��򵥣��Զ����£���ÿ���ڵ�Ϊ����������Ѱ�ҡ���������ҪDFSһ��������Ա���ÿһ�������㣬��Ҫ��DFS���ٽ���һ��DFS��ȡsumֵ�����������ıȽϼ򵥺��룬�������ԣ������˴������ظ����㣬�ٶȺ�����
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
����ܼ򵥣�ע�������֦���У���

## һ��DFS
�ڶ��������ǿ����������ģ��о�ʮ������������룺
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
�����Ǵ�����������Java�����е����ô��ݣ��������һ��ʼ������û�뵽�ġ���Ϊ�����ô��ݣ���˶���ÿ���ڵ���˵��`paths`ֻ�洢�˴Ӹ��ڵ㵽��ǰ�ڵ�·���ϵ�����ֵ�����ִ��η����Ҹо������ƹ㵽�������������⣬ֵ��ѧϰ��
��Σ���һ��ʼ���ָ÷���ʱ����Ϊ�Լ����ˣ�forѭ��ʹ����`for(int i = 0;i<=depth;i++)`�����������ⲻ����������������Ļ��������ظ��õ�һЩ�𰸣�����ÿ�εõ��Ĵ𰸶��ǴӸ��ڵ�����ģ�����Ŀ����������֮���Է����������Ϊ�˲��õ��ظ��Ĵ𰸣����ұ�֤ÿһ����϶������۵���

![image-20200916221413470](C:\Users\10343\AppData\Roaming\Typora\typora-user-images\image-20200916221413470.png)

��ͬ��������������Ϊ�������赱ǰ�ڵ���-2����ô��������[-2],[-3,-2],[1,-3,-2]��Ϊʲô������[1,-3]�أ���Ϊ����һ�εݹ��Ѿ����۹��ˡ�