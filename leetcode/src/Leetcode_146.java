import java.util.HashMap;

public class Leetcode_146 {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.printInfo();

        lru.put(2, 2);
        lru.printInfo();

        lru.get(1);
        lru.printInfo();

        lru.put(3, 3);
        lru.printInfo();

        lru.get(2);
        lru.printInfo();
        System.out.println("end");
    }

    static class LRUCache {
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
}
