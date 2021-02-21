import java.util.HashMap;

public class Offer35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node dummy = new Node(0);
        dummy.next = head;
        Node cur = head;
        Node newDummy = new Node(0), newPrev = newDummy;
        
        while (cur != null) {
            newPrev.next = new Node(cur.val);
            newPrev=newPrev.next;
            map.put(cur, newPrev);
            cur=cur.next;
        }

        cur = head;
        Node newCur = newDummy.next;
        while(cur!=null){
            if(cur.random==null){
                newCur.random=null;
            }else
                newCur.random=map.get(cur.random);
            newCur=newCur.next;
            cur=cur.next;
        }

        return newDummy.next;
    }
}
