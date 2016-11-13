/*
 * Time complexity: O(n) 
 * Space complexity: O(1)
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        if (root != null) {
            traverse(result, "", root);
        }
        return result;
    }
    
    private void traverse(List<String> list, String history, TreeNode root) {
        if (root != null) {
            if (!history.equals("")) {
                history += "->";
            }
            history += root.val;
        }
        
        if (root.left == null && root.right == null) {
            // leaf node
            list.add(history);
        } else {
            if (root.left != null) {
                traverse(list, history, root.left);
            }
            if (root.right != null) {
                traverse(list, history, root.right);
            }            
        }
    }
}