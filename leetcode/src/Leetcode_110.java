// ����һ�����������ж����Ƿ��Ǹ߶�ƽ��Ķ�������

// �����У�һ�ø߶�ƽ�����������Ϊ��

// һ��������ÿ���ڵ�?���������������ĸ߶Ȳ�ľ���ֵ������1��

// ʾ�� 1:

// ���������� [3,9,20,null,null,15,7]

//     3
//    / \
//   9  20
//     /  \
//    15   7
// ���� true ��

// ʾ�� 2:

// ���������� [1,2,2,3,3,null,null,4,4]

//        1
//       / \
//      2   2
//     / \
//    3   3
//   / \
//  4   4
// ����?false ��

// ��Դ�����ۣ�LeetCode��
// ���ӣ�https://leetcode-cn.com/problems/balanced-binary-tree
// ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    };
}

public class Leetcode_110 {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    int height(TreeNode node) {
        if (node == null)
            return 0;
        int leftheight = height(node.left);
        int rightheight = height(node.right);
        if (leftheight < 0 || rightheight < 0 || Math.abs(leftheight - rightheight) > 1)
            return -1;
        else
            return Math.max(leftheight, rightheight) + 1;
    }
}
