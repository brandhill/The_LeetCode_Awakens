/**
 * Author: Derek
 * Questions:
 * 1. 
 * 
 * Time: O(n)
 * Space:
 */
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
  public List<String> binaryTreePaths(TreeNode root) {
	List<String> result = new ArrayList<String>();
	StringBuilder sb = new StringBuilder();
	if (null != root) {
	  traceTreePaths(root, sb, result);
	}
	return result;
  }

  private void traceTreePaths(TreeNode node, StringBuilder sb, List<String> result) {
	int len = sb.length();
	sb.append(node.val);
	// leaf node
	if (null == node.left && null == node.right) {
	  result.add(sb.toString());

	}
	sb.append("->");
	if (null != node.left) traceTreePaths(node.left, sb, result);
	if (null != node.right) traceTreePaths(node.right, sb, result);
	sb.setLength(len);
  }
}
