/**
 * Created by Hill on 2016/11/4.
 * <p>
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * <p>
 * Space : O(1)
 * Time : O(n)
 */

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++) {

            if (head == null) {
                return null;
            }

            head = head.next;
        }

        ListNode preM_node = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postN_node = nNode.next;

        for (int i = m; i < n; i++) {

            if (postN_node == null) {
                return null;
            }

            ListNode temp = postN_node.next;
            postN_node.next = nNode;
            nNode = postN_node;
            postN_node = temp;
        }

        mNode.next = postN_node;
        preM_node.next = nNode;

        return dummy.next;
    }
}