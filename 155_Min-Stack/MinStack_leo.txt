/*
 * Authoer: Leo Lu
 * Question 1: what to do when pop(), top(), getMin() are called if the stack is empty
 *
 * Key: use another stack to record the change of the min value
 */

public class MinStack {
    private ListNode head;
    private ListNode mMinHead;
    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
        if (null == head) {
            head = new ListNode(x);
            mMinHead = new ListNode(x);
            return;
        }
        ListNode newNode = new ListNode(x);
        newNode.next = head;
        head = newNode;
        if (x <= mMinHead.val) {
            newNode = new ListNode(x);
            newNode.next = mMinHead;
            mMinHead = newNode;
        }
    }
    
    public void pop() {
        if (null == head) throw new IllegalStateException("stack is empty!!");
        if (head.val <= mMinHead.val) {
            mMinHead = mMinHead.next;
        }
        head = head.next;
    }
    
    public int top() {
        if (null == head) throw new IllegalStateException("stack is empty!!");
        return head.val;
    }
    
    public int getMin() {
        if (null == head) throw new IllegalStateException("stack is empty!!");
        return mMinHead.val;
    }
    private class ListNode {
      private ListNode next;
      private int val;
      ListNode(int x) {val = x;}
    }
}
