/* Time complexity: O(2n)
 * Space complexity: O(1)
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode newHeadA = headA;
        int count1 = 0;
        while (newHeadA != null) {
            count1++;
            newHeadA = newHeadA.next;
        }
    
        ListNode newHeadB = headB;    
        int count2 = 0;
        while (newHeadB != null) { 
            count2++;
            newHeadB = newHeadB.next;
        }

        newHeadA = headA;
        newHeadB = headB;        
        if (count1 > count2) {
            int diff = count1 - count2;
            while (diff != 0) {
                diff--;
                newHeadA = newHeadA.next;
            }
        } else if (count1 < count2) {
            int diff = count2 - count1;
            while (diff != 0) {
                diff--;
                newHeadB = newHeadB.next;
            }
        }
        
        while (newHeadA != null) {
            if (newHeadA == newHeadB) {
                return newHeadA;
            }
            
            newHeadA = newHeadA.next;
            newHeadB = newHeadB.next;
        }
        
        return null;
    }
}