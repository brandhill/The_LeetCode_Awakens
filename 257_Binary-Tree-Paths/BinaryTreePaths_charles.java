public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<String>();
        
        Stack<TreeNode> traversalStack = new Stack<TreeNode>();
        List<TreeNode> discoveredLeaves = new ArrayList<TreeNode>();
        List<String> result = new ArrayList<String>();
        TreeNode traversal = root, parent = null;
        traversalStack.push(root);
        
        while (traversalStack.size() != 0) {
            TreeNode node = traversalStack.peek();
            if (node.left == null && node.right == null) {
                // it's a leaf. dump the path and pop the stack.
                result.add(dumpPath(traversalStack));
                discoveredLeaves.add(traversalStack.pop());
            } else if (node.left != null && !discoveredLeaves.contains(node.left)) {
                traversalStack.push(node.left);
            } else if (node.right != null && !discoveredLeaves.contains(node.right)) {
                traversalStack.push(node.right);
            } else {
                discoveredLeaves.add(traversalStack.pop());
            }
        }
        
        return result;
    }
    
    private String dumpPath(Stack<TreeNode> stack) {
        StringBuilder builder = new StringBuilder();
        for (TreeNode node : stack) {
            builder.append(node.val + "->");
        }
        builder.delete(builder.length() - 2, builder.length());
        return builder.toString();
    }
}