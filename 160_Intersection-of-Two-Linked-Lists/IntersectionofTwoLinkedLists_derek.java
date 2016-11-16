/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	if (null == headA || null == headB) {
	  return null;
	}
	ListNode a = headA;
	ListNode b = headB;
	while(a != b) {
	  a = null == a ? headB : a.next;
	  b = null == b ? headA : b.next;
	}
	return a;
  }
}
