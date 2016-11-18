/**
# Question
* Does this tree contain duplicate values?

# thoughs
if node n is the common ancestor, one of those conditions should be true.
1. node p and q belongs to node's subtree. one in left and the other in the right.
2. node n is p or q, and the other one belongs to n's subtree.

we can do a **post-order** tree traversal to find p and q.
during the traversal, we will found the a node fulfill the conditions.

> **pre-order** makes code much compact
> A modified version of pre-order traversal. The point to understand this is, once a sub-branch has a possible ancestor, all its super branches will have the same one.

# Complexity
Time : n
Space: logn

 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // pre-order
        if(root == null || root == p || root == q)
            return root;

        TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q);

        if(leftResult != null && rightResult != null) {
            return root;
        }
        
        // post-order
        //if(root == p || root == q) {
        //    return root;
        //}
        
        return leftResult != null ? leftResult : rightResult;
    }
}
