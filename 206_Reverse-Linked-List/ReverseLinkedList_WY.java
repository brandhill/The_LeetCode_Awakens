/**
檢討：
Ln7 的邊界條件檢查是多餘的，可以被 Ln13的 while-loop 檢查取代
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode cur = head;
        ListNode tmp = null;
        
        while(cur != null) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        
        return prev;
    }
}
