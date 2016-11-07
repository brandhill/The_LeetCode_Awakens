/**
 * Created by hill on 08/11/2016.
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 *
 * Time: O (n logn) * O(min(m,n))
 * Space: O(1)
 *
 * Your runtime beats 98.68% of java submissions.
 */
public class MergekSortedLists {

    // Merge Sort Time : O(n logn)
    // https://www.khanacademy.org/computing/computer-science/algorithms/merge-sort/a/analysis-of-merge-sort
    public ListNode mergeKLists(ListNode[]  lists) {
        if (lists == null || lists.length == 0)
            return null;
        return MSort(lists, 0, lists.length - 1);
    }


    public ListNode MSort(ListNode[] lists, int low, int high) {
        if (low < high) { // merge 兩個 list 後回傳
            int mid = (low + high) / 2;
            ListNode leftlist = MSort(lists, low, mid);
            ListNode rightlist = MSort(lists, mid + 1, high);
            return mergeTwoLists(leftlist, rightlist);
        }
        return lists[low]; // 只有單一 list
    }



//    Space : O(1)
//    Time : O(min(m,n))

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }

        return dummyHead.next;
    }

}