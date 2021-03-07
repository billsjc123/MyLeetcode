# LRU

## 题目描述
运用你所掌握的数据结构，设计和实现一个? LRU (最近最少使用) 缓存机制 。
实现 LRUCache 类：

LRUCache(int capacity) 以正整数作为容量?capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value)?如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

进阶：你是否可以在?O(1) 时间复杂度内完成这两种操作？

示例：

输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
输出
[null, null, null, 1, null, -1, null, -1, 3, 4]

解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4


## 思路
实际上可以用双向链表+HashMap来实现。为什么要用这两个数据结构呢？
首先缓存的存、取需要在O(1)的时间复杂度内完成，这让我们联想到HashMap的数据结构，通过空间来换取时间。
然而题目还要求实现LRU机制，即我们要在存取中维护一个根据“访问时间”排序的优先队列，即最近访问过的节点应该放在最前，而最久未访问过的节点放在最后。于是我们可以使用一个双向链表来实现。

## 题解
1.  链表一般加上哑节点，这样可以减少很多不必要的边界判断
2.  本题的本质在于双向链表的增加、删除、移动，以及何时增加、合适移动。在实际编写代码的时候切记要画图来模拟，不然很容易漏掉一些情景

```java

class LRUCache {
    class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        Node(){};

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        };

    }

    private Node dummyHead, dummyTail;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private int capacity;
    private int count = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyHead = new Node(-1, 0);
        dummyTail = new Node(-1, 0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // already exist
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }
        // full
        if (count == capacity) {
            count--;
            // delete the tail of origin LinkedList
            deleteFromTail();
        }
        Node node = new Node(key, value);
        moveToHead(node);
        map.put(key, node);
        count++;
    }

    public void moveToHead(Node node) {
        if (map.containsKey(node.key)) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;

    }

    public void deleteFromTail() {
        Node tail = dummyTail.prev;
        map.remove(tail.key);

        tail.prev.next = dummyTail;
        dummyTail.prev = tail.prev;
        // GC
        tail.next = null;
        tail.prev = null;
    }

    public void printInfo() {
        System.out.println("----new turn----");
        Node temp = dummyHead;
        while (temp != dummyTail) {
            System.out.println("key:" + temp.key + "value:" + temp.value);
            temp = temp.next;
        }
    }
}
```
