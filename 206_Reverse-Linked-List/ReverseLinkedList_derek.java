/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Author: Derek Lai
 * Question:
 * 
 * Complexity:
 * 
 * Solution1:
 * Time: O(n)
 * Space:O(1)
 * 
 * Solution2:
 * Time:
 * Space:
 */
public class Solution {
  //Solution1: Iterative
  // public ListNode reverseList(ListNode head) {
  //     if (null == head) {
  //         return null;
  //     }
  //     ListNode prev = null, cur = head, next = null;
  //     while (null != cur) {
  //         next = cur.next;
  //         cur.next = prev;
  //         prev = cur;
  //         cur = next;
  //     }
  //     head = prev;
  //     return head;
  // }

  //Solution2: Recursive
  static public ListNode head;
  public ListNode reverseList(ListNode head) {
	if (null == head) {
	  return null;
	}

	return reverseUtil(head, null);
  }
  private ListNode reverseUtil(ListNode cur, ListNode prev) {
	//tail is found
	if (null == cur.next) {
	  head = cur;
	  cur.next = prev;
	  return head;
	}

	ListNode next1 = cur.next;
	cur.next = prev;
	reverseUtil(next1, cur);
	return head;
  }
}
