 /*
  * Q1: Can we change the content of input??
  */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int length = lists.length;
        while (length > 1) {
            for (int i = 0, j = length - 1; i < j; i++, j--) {
                lists[i] = merge(lists[i], lists[j]);
            }
            length = (length+1)>>1;
        }
        return lists[0];
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (null != l1 && null != l2) {
            if (l1.val <= l2.val) {
                current.next = l1;
                current = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                current = l2;
                l2 = l2.next;
            }
        }
        if (null != l1) {
            current.next = l1;
        } else {
            current.next = l2;
        }
        return dummy.next;
    }
}
