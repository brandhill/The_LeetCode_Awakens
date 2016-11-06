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
 * Questions:
 * 1.
 * 
 * Time:
 * Space:
 * 
 */
public class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
	if (m > n || null == head) {
	  return null;
	}
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	head = dummy;

	//Find premNode
	for (int i = 1; i<m; i++) {
	  if (null == head) return null;
	  head = head.next;
	}

	ListNode premNode = head, mNode = head.next, nNode = mNode, postnNode = mNode.next;
	ListNode temp;
	for (int i = m; i< n; i++) {
	  if (null == postnNode) {
		return null;
	  }
	  temp = postnNode.next;
	  postnNode.next = nNode;
	  nNode = postnNode;
	  postnNode = temp;
	}
	mNode.next = postnNode;
	premNode.next = nNode;
	return dummy.next;
  }
}
