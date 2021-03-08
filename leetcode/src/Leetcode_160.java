public class Leetcode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)return null;

        ListNode tempA = headA,tempB = headB;
        while(tempA!=tempB){
            tempA= tempA==null?headB:tempA.next;
            tempB= tempB==null?headA:tempB.next;
        }
        return tempA;
    }
}
