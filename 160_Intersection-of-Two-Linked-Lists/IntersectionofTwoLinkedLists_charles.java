public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA, nodeB = headB;
        int lengthA = 0, lengthB = 0;
        while (nodeA != null) {
            ++lengthA;
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            ++lengthB;
            nodeB = nodeB.next;
        }
        
        nodeA = headA;
        nodeB = headB;
        while (lengthA != lengthB) {
            if (lengthA > lengthB) {
                nodeA = nodeA.next;
                --lengthA;
            } else {
                nodeB = nodeB.next;
                --lengthB;
            }
        }
        
        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        
        return nodeA;
        
    }
}