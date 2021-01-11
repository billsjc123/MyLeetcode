给定一个 ? 完美二叉树 ?，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

struct Node {
int val;
Node *left;
Node *right;
Node \*next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 ?next 指针都被设置为 NULL。



进阶：

你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。

# Solution

O(N)级别的空间复杂度的解法不提，考虑 O(1)的解法。

考虑到题目强调该题为完美二叉树，即满二叉树，则每个非叶节点必有两个子节点。很明显 next 指针有如下情况：

1.  每层的第一个节点没有任何 next 指向它
2.  每个非叶节点的左子节点指向右子节点
3.  每个非叶节点的右子节点指向该非叶节点的 next 的 left

因此只需记录下每层的第一个节点，从该节点开始向右遍历，更新子节点的 next 指针即可。

```java
public Node connect(Node root) {
    if (root == null)
        return null;

    Node curLevel = root;

    // 指向下一层的第一个节点
    Node nextLevel = curLevel.left;
    // 处理完最后一层时curLevel指向null
    while (nextLevel != null) {

        // 处理该层第一个Node
        curLevel.left.next = curLevel.right;
        Node tmp = curLevel.right;
        curLevel = curLevel.next;

        // 该层处理到最后一个节点
        while (curLevel != null) {
            tmp.next = curLevel.left;
            curLevel.left.next = curLevel.right;
            tmp = curLevel.right;
            curLevel = curLevel.next;
        }
        curLevel = nextLevel;
        nextLevel = curLevel.left;
    }
    return root;
}

```
