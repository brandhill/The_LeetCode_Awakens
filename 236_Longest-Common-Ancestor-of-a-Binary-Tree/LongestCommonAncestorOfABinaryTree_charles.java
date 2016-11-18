/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode currentNode = root;
        
        if (root == null || p == null || q == null) throw new IllegalArgumentException("illegal input");
        
        if (root == p) return p;
        if (root == q) return q;
        
        Stack<TreeNode> pTraversal = new Stack<TreeNode>();
        Stack<TreeNode> qTraversal = new Stack<TreeNode>();
        pTraversal.clear();
        qTraversal.clear();
        
        findPath(pTraversal, null, root, p);
        findPath(qTraversal, null, root, q);
        
        for (int i = 0; i < Math.min(pTraversal.size(), qTraversal.size()); ++i) {
            if ((pTraversal.get(i) != qTraversal.get(i))) {
                    return pTraversal.get(i - 1);
                }
        }
        
        // should never be here!
        return null;
    }
    
    private boolean findPath(Stack<TreeNode> stack, List<TreeNode> discoveredNodes, TreeNode root, TreeNode x) {
        if (discoveredNodes == null) discoveredNodes = new ArrayList<TreeNode>();
        stack.push(root);
        
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            
            if (node.val == x.val) {
                return true;
            }
            
            if (node.left == null && node.right == null) {
                discoveredNodes.add(node);
                stack.pop();
            } else if (node.left != null && !discoveredNodes.contains(node.left)) {
                stack.push(node.left);
            } else if (node.right != null && !discoveredNodes.contains(node.right)) {
                stack.push(node.right);
            } else {
                discoveredNodes.add(node);
                stack.pop();
            }
        }
        
        // cannot find the node. should not be here!
        return false;
    }
    
    /* recursive version */
    /*
    private boolean findPath(List<TreeNode> list, TreeNode root, TreeNode x) {
        
        if (root == null) return false;
        
        System.out.println("checking node " + root.val);
        
        if (root.left == null && root.right == null) {
            if (root == x) {
                System.out.println("found " + x.val);
                list.add(x);
                
                StringBuilder builder = new StringBuilder();
                for (TreeNode t : list) {
                    builder.append(t.val).append(" ");
                }
                
                return true;
            } else {
                return false;
            }
        }
        if (findPath(list, root.left, x) || findPath(list, root.right, x)) {
            return true;
        } else {
            return false;
        }
    }*/
}