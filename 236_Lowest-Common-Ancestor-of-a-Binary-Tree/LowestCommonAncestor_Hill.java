/**
 * Created by hill on 20/11/2016.
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5,
 * since a node can be a descendant of itself according to the LCA definition.
 *
 * Time : O(n)
 * Space: O(1)
 *
 * 解題思路:
 * 用 BFS 的方式來尋訪節點，每個節點都回傳是否為 p or q 的 Ancestor （這也包含本身是否為 p or q ）
 * 當某一點得知左、右 子節點都是 Ancestor ，就表示他是 p 和 q Ancestor，就把自己回傳
 *
 *
 * 注意
 * (*1). 因為會有重複的節點，所以判斷  是否為 p or q 的 Ancestor （這也包含本身是否為 p or q ） 時
 * 要用 reference 的方式來判斷
 *
 *
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }

        // this node is the Ancestor of p/q, or itself
        if (root == p || root == q) { //(*1)
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // this node is the Common Ancestor of p and q
        if(left !=null && right != null){
            return root;
        }else if(left ==null && right == null){
            return null;
        }

        return (left==null) ? right : left;
    }

}