/**
   Created by Hill on 2016/1/1.

   Difficulty: Easy, Frequency: Medium

   https://leetcode.com/problems/merge-two-sorted-lists/

   Space : O(1)
   Time : O(min(m,n))

    Your runtime beats 44.56% of java submissions.
 */


public class MergeTwoSortedLists {

    public static ListNode getSolution(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (l1 != null && l2 !=null){
            if(l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            }else{
                cur.next = l1;
                l1 = l1.next;
            }

            cur = cur.next;
        }

        if(l1 !=null){
            cur.next = l1;
        }else{
            cur.next = l2;
        }

        return dummyHead.next;
    }

}