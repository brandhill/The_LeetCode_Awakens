public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pivot1 = head;
        ListNode pivot2 = head;

        while (pivot1 != null) {
            if (pivot1 == head) {
                pivot1 = head.next;
                pivot2 = head.next;
                head.next = null;
            } else {
                pivot2 = pivot1.next;
                pivot1.next = head;
                head = pivot1;
                pivot1 = pivot2;
            }
        }
        return head;
    }
}
