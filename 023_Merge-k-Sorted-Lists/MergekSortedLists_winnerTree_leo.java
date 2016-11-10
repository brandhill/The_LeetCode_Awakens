 /*
  * Q1: Can we change the content of input??
  */
public class Solution {
    class WinnerTree {
        ListNode[] nodeTree;
        ListNode[] lists;
        int[] nodeNum;
        int treeNum;
        int size = 1;
        WinnerTree(ListNode[] lists) {
            this.lists = lists;
            treeNum = lists.length;
            int len = treeNum-1;
            while (len > 0) {
                size <<= 1;
                len >>= 1;
            }
            size = (size<<1)-1;
            nodeTree = new ListNode[size];
            nodeNum = new int[size];
            int index = size/2;
            for (int i = 0, k = treeNum; i < k; i++) {
                nodeNum[index] = i;
                if (lists[i] != null) {
                    nodeTree[index] = lists[i];
                } else {
                    nodeTree[index] = new ListNode(Integer.MAX_VALUE);
                    treeNum--;
                }
                index++;
            }
            while (index < size) {
                nodeTree[index] = new ListNode(Integer.MAX_VALUE);
                nodeNum[index++] = -1;
            }
            
            for (int start = size>>1, end = size-1; start >0; start = (start-1)>>1, end = (end-1)>>1) {
                for (int i = start; i < end; i +=2 ) {
                    int winner = nodeTree[i].val <= nodeTree[i+1].val ? i : i+1;
                    int f = (i-1)>>1;
                    nodeNum[f] = nodeNum[winner];
                    nodeTree[f] = nodeTree[winner];
                }
            }
        }
        
        ListNode pop() {
            if (treeNum<=0) return null;
            ListNode ret = nodeTree[0];
            
            int k = nodeNum[0];
            
            ListNode next = ret.next;
            if (null == next) {
                treeNum--;
                next = new ListNode(Integer.MAX_VALUE);
            }
            
            int start = (size>>1) + k;
            nodeTree[start] = next;
            for (int i = start; i > 0; i = (i-1)>>1) {
                int other = (i&1) != 0 ? i+1 : i-1;
                int f = (i-1)>>1;
                int winner = nodeTree[i].val <= nodeTree[other].val ? i : other;
                nodeNum[f] = nodeNum[winner];
                nodeTree[f] = nodeTree[winner];
            }
            return ret;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        WinnerTree tree = new WinnerTree(lists);
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode node;
        while ((node = tree.pop()) != null) {
            current.next = node;
            current = node;
        }
        return dummy.next;
    }
}
