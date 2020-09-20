# Leetcode 114.������תΪ����

> <a href="https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/">����һ�Ŷ�����������ǰ�������˳�򽫸ö�����**ԭ��**תΪһ��������</a>

��������ĳ���˼·һ�㶼�����£�

## ����һ��ǰ�����+�ڵ��¼

ʹ��ǰ�����������ȫ�ֱ���pre��cur��¼ǰһ���������Ľڵ㣬���ڵ����������Ϊ��ǰ�ڵ㣬���ʵ�������ԭ��ת����

���Ǹ�˼·��һ�����塪�����ʹ�õݹ���㷨��ÿ�ν��н�pre���������޸�Ϊ��ǰ�ڵ�curʱ��pre���ҽڵ�ᶪʧ��

���Զ���ǰ�������ֻ��ʹ�õ����ķ���������ջ�����桱ÿ���ڵ㣬�ڱ�������ʱ�ٵ�����

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

## ������ �������+�ڵ��¼

ͬ�ϣ���Ϊ��������ʹ���ҽڵ�������ӣ����ʹ�õݹ�ᶪʧ�ҽڵ㡣Ϊʲô�ᶪʧ�ҽڵ��أ�**��Ϊʹ��ǰ�������ʱ�����ȷ����Լ����ٷ����ҽڵ㣬��˷������Լ�֮�󣬾ͻ��޸��ҽڵ㣬��ʱ�ͻ���ֶ�ʧ**����ô���������������ÿ���ȷ����ҽڵ㣬�ٷ����Լ����Ϳ��Աܿ�������⡣

Ϊ��ʹ˳��һ�£�ʹ�ú��������ķ���˳��Ӧ����ǰ�������reverse����˺������Ӧ�����ȱ����������ٱ�����������

ʹ��ȫ�ֱ���pre����pre��¼Ϊ��ǰ�ڵ����һ���ڵ㣬ÿ�η���ʱ���ýڵ���ҽڵ���Ϊpre����

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



