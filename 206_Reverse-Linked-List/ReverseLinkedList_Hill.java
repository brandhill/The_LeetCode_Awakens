/**
 * Created by hill on 2016/11/3.
 * <p>
 * http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/
 * <p>
 * Your runtime beats 31.80% of java submissions.
 * <p>
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * <p>
 * Time:  O(n)
 * Space: O(1)
 */
public class ReverseLinkedList {


    public static ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        head = pre;
        return head;
    }
}