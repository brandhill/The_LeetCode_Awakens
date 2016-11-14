/**
 * Created by hill on 14/11/2016.
 * <p>
 * https://leetcode.com/problems/binary-tree-paths/
 * <p>
 * <p>
 * Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * <p>
 * <p>
 * ["1->2->5", "1->3"]
 *
 * Time:   O(n)
 *
 * Space:  O(n)
 * 所有 path 的數量相當於 leaf 的總量 >> n/2
 * 所以是 O(n)
 *
 * Your runtime beats 62.65% of java submissions.
 */
public class BinaryTreePaths {

    public static List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        findPathToLeaf(root, result, String.valueOf(root.val));

        return result;
    }

    public static void findPathToLeaf(TreeNode node, List<String> result, String currPath) {

        if(node == null){
            return;
        }

        // it is leaf.
        if (node.right == null && node.left == null) {
            result.add(currPath);
        }

        if (node.left != null) {
            findPathToLeaf(node.left, result, currPath + "->" + node.left.val);
        }

        if (node.right != null) {
            findPathToLeaf(node.right, result, currPath + "->" + node.right.val);
        }

    }

}