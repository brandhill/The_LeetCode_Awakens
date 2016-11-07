/**
 * Time : O(logN)
 * Space: O(N)
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        dump(root, null, ret);
        return ret;
    }
    
    private void dump(TreeNode node, String s, List<String> bag) {
        if(node == null)
            return;
        if(s == null) {
            s = "" + node.val;
        } else {
            s = s + "->" + node.val;
        }
        if(node.left == null && node.right == null) {
            bag.add(s);
            return;
        }
        
        if(node.left != null) dump(node.left, s, bag);
        if(node.right != null) dump(node.right, s, bag);
    }
}
