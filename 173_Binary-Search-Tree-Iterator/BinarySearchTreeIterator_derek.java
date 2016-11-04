/**
 * Author:Derek Lai
 * Question
 * 1.root node must not be null!
 * 2.
 * 
 * Time :O(h)
 * Space:O(n)
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
  private Stack<TreeNode> mData = new Stack<TreeNode>();
  private TreeNode mCurNode;

  public BSTIterator(TreeNode root) {
	mCurNode = root;
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
	return null != mCurNode
	  || mData.size() > 0;
  }

  /** @return the next smallest number */
  public int next() {
	while(null != mCurNode) {
	  mData.push(mCurNode);
	  mCurNode = mCurNode.left;
	}
	mCurNode = mData.pop();
	TreeNode minNode = mCurNode;
	mCurNode = mCurNode.right;
	return minNode.val;
  }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
