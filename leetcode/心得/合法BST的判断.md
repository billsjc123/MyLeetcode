# �Ϸ��������������ж�
���ںϷ��Ķ�����������һ��������������
1.  �ýڵ��������ϵ����н���ֵС�ڵ�ǰ�ڵ㣻�����������н���ֵ���ڵ�ǰ�ڵ�
2.  �������������ܴ���������ȵĽڵ㣨��ȷ���false��
3.  ����1�����Ƴ�����������������������ǵ�������������

## ����һ���������
���ݶ���3���Եõ��������ǰ��������Ľ������һ���������������У���ô����false���෴����true��
�����ڴ�������в�����Ҫ�����������У���ʵ��ֻҪ֪����һ�����Ƕ��ټ��ɡ�����ѧ���ɷ���
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
�ڴ���������һ��ջ��Ϊ������ÿ���ж���pop���������ֵ��

## ����������¼���ֵ����Сֵ
���ҵ�һ���������ʱ������һ�������ҵ��ж������ǣ�������������������Ƕ����������ҵ�ǰ�ڵ�ֵ����������rootֵС��������rootֵ���򷵻�true��
��������ԭ��������û�п��ǵ�����������root�����������������Ľڵ㣬��������rootͬ�����Ҫ�����жϣ����뽫��ǰ�ڵ�������������ڵ�����жϡ�
������һ�㣬��ʵ����ʹ������˼ά�������ǰ�ڵ���������������ڵ㣬��ô��ǰ�ڵ���������е�����һ��ֵ��Ҫ����ô�����������һ��ֵ����������ֵ����Ҫ�󣬷���false���ɡ�������ڲ����м�¼�µ�ǰ�����ġ�MIN���͡�MAX���������бȽϣ�����˸���.
ֵ��ע����ǣ�������һ���ӵ�����[2147483647]�����ʹ��int������������ʹ����Long����intתLongʹ��Long.valueOf(int value)
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