/**
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0)
            return null;

        while(n > 1) {
            int i = 0;
            int j = n-1;
        
            while(i < j) {
                lists[i] = merge(lists[i], lists[j]);
                lists[j] = null;
                i++;
                j--;
            }
            n = (n + 1) / 2;
        }
        
        return lists[0];
    }
    
    private ListNode merge(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode ret, target;
        if(list1.val < list2.val) {
            ret = list1;
            target = list2;
        } else {
            ret = list2;
            target = list1;
        }
        
        ListNode curr = ret;
        while(target != null) {
            while(curr.next != null && curr.next.val < target.val) {
                curr = curr.next;
            }

            ListNode tmp = target.next;
            target.next = curr.next;
            curr.next = target;
            
            target = tmp;
        }
        
        return ret;
    }
}
