* **Calculate the difference in len**
  * Time complexity: O(2n)
  * Space complexity: O(1)
```
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
```
* **Without knowning the difference in len**
  * Time complexity: O(m+n)
  * Space complexity: O(1)
```
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //boundary check
    if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a;
}
```
