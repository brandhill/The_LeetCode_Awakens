/**
LinkedList
可以進行的操作就是 pointer的移動

* Key Point
List長度 m & n
兩個list 都移動 m + n  時，一定會相遇

* 心得
pointer不一定要黏在原來的List 身上

 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null) {
            return null;
        }

        ListNode h1 = headA;
        ListNode h2 = headB;
        while(h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        
        
        return h1;
    }
}
