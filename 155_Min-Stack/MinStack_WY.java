/**
 * # question
 * what you like to handle pop() / top() / getMin() if there is no element
 * # thoughts
 * the number of input could be very large.
 * use linked list instead of fixed-size array

 * # 檢討
 * 沒有用test case 手動檢查過
 * LinkedList 可以反過來指定
 * A->B->C
 * A<-B<-C<-HEAD
 */
public class MinStack {

    /** initialize your data structure here. */
    static class Node {
        final int val;
        Node next = null;
        Node prev = null;
        Node nextSmall = null;
        
        Node(int val) {
            this.val = val;
        }
    }
    
    Node topNode;
    Node minNode;
    
    public MinStack() {
    }
    
    public void push(int x) {
        if(topNode == null) {
            topNode = new Node(x);
            minNode = topNode;
        } else {
            Node node = new Node(x);
            node.prev = topNode;
            topNode.next = node;
            topNode = node;
            
            if(minNode.val > node.val) {
                node.nextSmall = minNode;
                minNode = node;
            }
        }
    }
    
    public void pop() {
        if(topNode != null) {
            if(topNode == minNode) {
                minNode = minNode.nextSmall;
            }
            Node prev = topNode.prev;
            if(prev != null) {
                prev.next = null;
            }
            topNode = prev;
            
        }
    }
    
    public int top() {
        if(topNode != null) {
            return topNode.val;
        }
        
        throw new RuntimeException("empty stack");
    }
    
    public int getMin() {
        if(minNode != null) {
            return minNode.val;
        }
        
        throw new RuntimeException("empty stack");
    }
}
