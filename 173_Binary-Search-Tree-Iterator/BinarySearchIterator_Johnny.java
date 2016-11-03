/*
 * Author: Johnny Lee
 * Time Complexity: Average O(n)
 * Space Complexity: O(h)
 * Question1: 已跪...應該沒別招了
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