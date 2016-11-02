 /*
  * Auther: Johnny Lee
  * Time:  O(n)
  * Space: O(1)
  */

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode lastHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = lastHead;
            lastHead = head;
            head = next;
        }
        
        return lastHead;
    }
}