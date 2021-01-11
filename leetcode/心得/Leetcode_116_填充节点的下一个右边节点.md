����һ�� ? ���������� ?��������Ҷ�ӽڵ㶼��ͬһ�㣬ÿ�����ڵ㶼�������ӽڵ㡣�������������£�

struct Node {
int val;
Node *left;
Node *right;
Node \*next;
}
�������ÿ�� next ָ�룬�����ָ��ָ������һ���Ҳ�ڵ㡣����Ҳ�����һ���Ҳ�ڵ㣬�� next ָ������Ϊ NULL��

��ʼ״̬�£����� ?next ָ�붼������Ϊ NULL��



���ף�

��ֻ��ʹ�ó���������ռ䡣
ʹ�õݹ����Ҳ����Ҫ�󣬱����еݹ����ռ�õ�ջ�ռ䲻��������Ŀռ临�Ӷȡ�

# Solution

O(N)����Ŀռ临�ӶȵĽⷨ���ᣬ���� O(1)�Ľⷨ��

���ǵ���Ŀǿ������Ϊ��������������������������ÿ����Ҷ�ڵ���������ӽڵ㡣������ next ָ�������������

1.  ÿ��ĵ�һ���ڵ�û���κ� next ָ����
2.  ÿ����Ҷ�ڵ�����ӽڵ�ָ�����ӽڵ�
3.  ÿ����Ҷ�ڵ�����ӽڵ�ָ��÷�Ҷ�ڵ�� next �� left

���ֻ���¼��ÿ��ĵ�һ���ڵ㣬�Ӹýڵ㿪ʼ���ұ����������ӽڵ�� next ָ�뼴�ɡ�

```java
public Node connect(Node root) {
    if (root == null)
        return null;

    Node curLevel = root;

    // ָ����һ��ĵ�һ���ڵ�
    Node nextLevel = curLevel.left;
    // ���������һ��ʱcurLevelָ��null
    while (nextLevel != null) {

        // ����ò��һ��Node
        curLevel.left.next = curLevel.right;
        Node tmp = curLevel.right;
        curLevel = curLevel.next;

        // �ò㴦�����һ���ڵ�
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
