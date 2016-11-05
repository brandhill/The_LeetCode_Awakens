/**
 * Created by hill on 2016/11/05.
 * <p>
 * https://leetcode.com/problems/min-stack/
 * <p>
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 * <p>
 * Your runtime beats 95.47% of java submissions.
 * <p>
 * * Ask interviewer about following questions:
 * 1. What value should be returned if the stack is empty?
 * <p>
 * <p>
 * <p>
 * <p>
 * 思路：利用 LinkedList 來實做這個 stack
 * 特別的是每個節點 (Node) 除了存這個節點的值、下個節點的連結，
 * 還要儲存以這個節點當做 list head 時，這個 list 裏面最小的值
 * 因此就可以在 constant time 取得 minimum element of stack
 */
public class MinStack {

    private class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min) {
            this(val, min, null);
        }

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }

    }

    private Node top;

    public MinStack() {
    }

    public void push(int x) {

        if (top == null) {
            top = new Node(x, x);
        } else {
            top = new Node(x, Math.min(x, top.min), top);
        }

    }

    public void pop() {
        top = top.next;
    }

    public int top() {
        if (top != null) {
            return top.val;
        } else {
            return 0;
        }

    }

    public int getMin() {
        if (top != null) {
            return top.min;
        } else {
            return 0;
        }
    }

}