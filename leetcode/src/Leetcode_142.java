public class Leetcode_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head.next, fast = head.next.next;
        // 第一次相遇
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 第二次相遇
        ListNode front = head;
        while (slow != front) {
            slow = slow.next;
            front = front.next;
        }
        return front;
    }
}
