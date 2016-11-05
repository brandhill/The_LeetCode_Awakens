public class BSTIterator {

    Stack<TreeNode> mStack = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        dfs(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return mStack.size() > 0;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = mStack.pop();
        dfs(node.right);
        
        return node.val;
    }
    
    private void dfs(TreeNode node) {
        TreeNode curr = node;
        while(curr != null) {
            mStack.push(curr);
            curr = curr.left;
        }
    }
}
