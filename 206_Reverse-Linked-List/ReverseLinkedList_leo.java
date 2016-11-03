 /*
  * Auther: Leo Lu
  * Question 1: Should we modify the input??
  * Time:  O(n)
  * Space: O(1)
  */
 
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (null != head) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}
