/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Author:Derek Lai
 * Questions:
 * 1. Empty list ?
 * 2. What's the value should be return if the parameter is null ?
 */
public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
	final int size = null != lists ? lists.length : 0;
	if (size <= 0) return null;
	return mergeHelper(lists, 0, lists.length - 1);
  }

  private ListNode mergeHelper(ListNode[] lists, int start, int end) {
	if (start == end) {
	  return lists[start];
	}
	int mid = start + (end-start) / 2;
	ListNode left = mergeHelper(lists, start, mid);
	ListNode right = mergeHelper(lists, mid+1, end);
	return mergeTwoList(left, right);
  }

  private ListNode mergeTwoList(ListNode left, ListNode right) {
	ListNode dummy = new ListNode(0);
	ListNode tail = dummy;
	while (null != left && null != right) {
	  if (left.val < right.val) {
		tail.next = left;
		tail = left;
		left = left.next;
	  } else {
		tail.next = right;
		tail = right;
		right = right.next;
	  }
	}

	if (null != left) {
	  tail.next = left;
	} else {
	  tail.next = right;
	}

	return dummy.next;
  }
}
