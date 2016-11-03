/*
 * Author: Leo Lu
 */

public class BSTIterator {
    private LinkedList<TreeNode> mStack = new LinkedList<>();
    private void addAllLeft(TreeNode root) {
        do {
            mStack.addFirst(root);
            root = root.left;
        } while (root != null);
    }
    public BSTIterator(TreeNode root) {
        if (null != root) addAllLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !mStack.isEmpty();    
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = mStack.removeFirst();
        if (null != node.right) addAllLeft(node.right);
        return node.val;
    }
}
