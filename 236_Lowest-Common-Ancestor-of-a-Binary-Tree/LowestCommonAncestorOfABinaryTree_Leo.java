/** Time:  O(n)
  * Space: O(ln(n))
  */

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || root == p || root == q) return root;
        TreeNode l =  lowestCommonAncestor(root.left, p, q);
        TreeNode r =  lowestCommonAncestor(root.right, p, q);
        if (l != null) {
          return (r != null) ? root : l;
        }
         
        return r;
    }
}
