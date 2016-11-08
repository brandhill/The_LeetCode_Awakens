/*
*  Time: O(n)
* Space: O(ln(n))
*/
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root != null) dfsTraverse(root, new StringBuilder() ret);
        return ret;
    }
    private void dfsTraverse(TreeNode node, StringBuilder sb, List<String> ret) {
        int len = sb.length();
        sb.append(node.val);
        if (node.left == null && node.right == null) ret.add(sb.toString());
        int length = sb.length();
        if (node.left != null) {
            dfsTraverse(node.left, sb.append("->"), ret);
            sb.delete(length, length+2);
        }
        if (node.right != null) {
            dfsTraverse(node.right, sb.append("->"), ret);
            sb.delete(length, length+2);
        }
        sb.delete(len, sb.length());
    }
}
