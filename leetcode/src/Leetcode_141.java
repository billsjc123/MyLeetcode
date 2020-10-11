import java.util.List;

public class Leetcode_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            fast = fast.next;
            if (fast==null)
                return true;
            fast = fast.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}
