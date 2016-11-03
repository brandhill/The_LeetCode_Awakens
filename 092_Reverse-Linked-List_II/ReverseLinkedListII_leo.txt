/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 /*
  * Author: Leo Lu
  * Time :O(n)
  * Sppce:O(1)
 */
 
public class Solution {
     public ListNode reverseBetween(ListNode head, int m, int n) {
        if(null == head) return null;
        ListNode node = head;
        ListNode nodeBeforeStart = null;
        for (int i = 1; i < m; i++) {
            if (null == node) return head;
            nodeBeforeStart = node;
            node = node.next;
        }
        ListNode startNode = node;
        
        ListNode prev = null;
        for (int i = m; i <= n; i++) {
            if (null == node) break;
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
         
        if (null != nodeBeforeStart) {
            nodeBeforeStart.next = prev;
        } else {
            head = prev;
        }
        startNode.next = node;
                 
        return head;
    }
}
