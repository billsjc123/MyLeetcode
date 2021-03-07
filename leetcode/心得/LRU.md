# LRU

## ��Ŀ����
�����������յ����ݽṹ����ƺ�ʵ��һ��? LRU (�������ʹ��) ������� ��
ʵ�� LRUCache �ࣺ

LRUCache(int capacity) ����������Ϊ����?capacity ��ʼ�� LRU ����
int get(int key) ����ؼ��� key �����ڻ����У��򷵻عؼ��ֵ�ֵ�����򷵻� -1 ��
void put(int key, int value)?����ؼ����Ѿ����ڣ�����������ֵ������ؼ��ֲ����ڣ��������顸�ؼ���-ֵ���������������ﵽ����ʱ����Ӧ����д��������֮ǰɾ�����δʹ�õ�����ֵ���Ӷ�Ϊ�µ�����ֵ�����ռ䡣

���ף����Ƿ������?O(1) ʱ�临�Ӷ�����������ֲ�����

ʾ����

����
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
���
[null, null, null, 1, null, -1, null, -1, 3, 4]

����
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // ������ {1=1}
lRUCache.put(2, 2); // ������ {1=1, 2=2}
lRUCache.get(1);    // ���� 1
lRUCache.put(3, 3); // �ò�����ʹ�ùؼ��� 2 ���ϣ������� {1=1, 3=3}
lRUCache.get(2);    // ���� -1 (δ�ҵ�)
lRUCache.put(4, 4); // �ò�����ʹ�ùؼ��� 1 ���ϣ������� {4=4, 3=3}
lRUCache.get(1);    // ���� -1 (δ�ҵ�)
lRUCache.get(3);    // ���� 3
lRUCache.get(4);    // ���� 4


## ˼·
ʵ���Ͽ�����˫������+HashMap��ʵ�֡�ΪʲôҪ�����������ݽṹ�أ�
���Ȼ���Ĵ桢ȡ��Ҫ��O(1)��ʱ�临�Ӷ�����ɣ������������뵽HashMap�����ݽṹ��ͨ���ռ�����ȡʱ�䡣
Ȼ����Ŀ��Ҫ��ʵ��LRU���ƣ�������Ҫ�ڴ�ȡ��ά��һ�����ݡ�����ʱ�䡱��������ȶ��У���������ʹ��Ľڵ�Ӧ�÷�����ǰ�������δ���ʹ��Ľڵ��������������ǿ���ʹ��һ��˫��������ʵ�֡�

## ���
1.  ����һ������ƽڵ㣬�������Լ��ٺܶ಻��Ҫ�ı߽��ж�
2.  ����ı�������˫����������ӡ�ɾ�����ƶ����Լ���ʱ���ӡ������ƶ�����ʵ�ʱ�д�����ʱ���м�Ҫ��ͼ��ģ�⣬��Ȼ������©��һЩ�龰

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
