public class Leetcode_706 {
    class MyHashMap {
        class Node{
            int key;
            int value;
            Node next;
            public Node(int key,int val){this.key=key;this.value=val;}
        }
    
        static private final int  TABLE_SIZE = 10;
    
        Node[] table = new Node[TABLE_SIZE];
        /** Initialize your data structure here. */
        public MyHashMap() {
    
        }
        
        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hash = key%TABLE_SIZE;
            if(table[hash]==null){
                table[hash]=new Node(key,value);
            }else{
                Node temp = table[hash];
                while(temp!=null){
                    if(temp.key==key){
                        temp.value=value;
                        return;
                    }
                    temp=temp.next;
                }
                Node newNode = new Node(key,value);
                newNode.next=table[hash];
                table[hash]=newNode;
            }
        }
        
        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int hash = key%TABLE_SIZE;
            if(table[hash]==null)return -1;
            
            Node temp = table[hash];
            while(temp!=null){
                if(temp.key==key)return temp.value;
                temp=temp.next;
            }
            return -1;
        }
        
        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int hash = key%TABLE_SIZE;
            if(table[hash]==null)return;
    
            Node temp = table[hash];
            if(temp.key==key){
                table[hash]=temp.next;
                return;
            }
            Node prev = table[hash];
            temp=temp.next;
            while(temp!=null){
                if(temp.key==key){
                    prev.next=temp.next;
                    // GC
                    temp=null;
                    return;
                }
                temp=temp.next;
            }
        }
    }
    
    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
}
