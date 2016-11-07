public class Solution {
    private int getLength(ListNode node) {
        int len = 0;
        for (;null != node; node = node.next) len++;
        return len;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) return null;
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        ListNode na = headA;
        ListNode nb = headB;
        
        int diff = lenA - lenB;
        if (diff < 0) {
            diff = - diff;
            na = headB;
            nb = headA;
        }
        
        for (int i = 0; i < diff; i++) na = na.next;
        
        while (na != nb) {
            na = na.next;
            nb = nb.next;
        }
        return na;
    }
}
