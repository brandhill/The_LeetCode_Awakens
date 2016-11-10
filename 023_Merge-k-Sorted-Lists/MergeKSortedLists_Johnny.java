/*
  Auther: Johnny Lee
  Time complexicity: O(nklogk)
  Space complexitty: O(k)
 */

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue(16, 
            new Comparator<ListNode>() {
                public int compare(ListNode n1, ListNode n2) {
                    if (n1.val > n2.val) {
                        return 1;
                    } else if (n1.val < n2.val) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        );
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        
        ListNode head = null;
        ListNode tail = null;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (head == null) {
                head = node;
            }
            if (tail == null) {
                tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            if (tail.next != null) {
                queue.add(tail.next);
            }
        }
        
        return head;
    }
}