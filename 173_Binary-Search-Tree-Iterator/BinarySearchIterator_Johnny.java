/*
 * Author: Johnny Lee
 * Time Complexity: Average O(1)
 * Space Complexity: O(h)
 * Question1: 已跪...應該沒別招了
 * 補充： stack內建synchornize會比linkedlist慢
 */
public class BSTIterator {
    private Stack<TreeNode> mStack = new Stack();
    public BSTIterator(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            mStack.push(node);
            node = node.left;            
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !mStack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode smallest = mStack.pop();
        TreeNode node = smallest.right;
        while (node != null) {
            mStack.push(node);
            node = node.left;
        }
        
        return smallest.val;
    }
}