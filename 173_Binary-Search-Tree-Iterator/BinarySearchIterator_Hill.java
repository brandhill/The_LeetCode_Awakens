/**
 * Created by hill on 06/11/2016.
 * <p>
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * <p>
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * <p>
 * <p>
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 * <p>
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 * <p>
 * <p>
 * <p>
 * * Ask interviewer about following questions:
 * 1. Is this BSTIterator used to be part of in-order tree traversal
 *
 *
 * time: O(1)
 * Space: O(h),  where h is the height of the tree.
 *
 *
 * Your runtime beats 18.34% of java submissions.
 */

public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        if (root != null){
            addAllLeft(root);
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty() ;
    }

    public int next() {

        TreeNode node = stack.pop();

        if (node.right != null){
            addAllLeft(node.right);
        }

        return node.val;

    }

    public void addAllLeft(TreeNode node){
        while (node != null){
            stack.push(node);
            node = node.left;
        }
    }

}