/*
  Auther: Johnny Lee
  Question 1: What value should top() or getMin() method return when stack is empty?
  Time complexicity: O (1)
  Space complexitty: O(n)
 */
public class MinStack {
    class Node {
        int val;
        int min;
        Node next;
        
        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    
    private Node mHead = null;
    
    /** initialize your data structure here. */
    public MinStack() {
            
    }
    
    public void push(int x) {
        if (mHead != null) {
            mHead = new Node(x, x < mHead.min ? x : mHead.min, mHead);
        } else {
            mHead = new Node(x, x, null);
        }
    }
    
    public void pop() {
        mHead = mHead.next;
    }
    
    public int top() {
        return mHead.val;
    }
    
    public int getMin() {
        return mHead.min;
    }
}
