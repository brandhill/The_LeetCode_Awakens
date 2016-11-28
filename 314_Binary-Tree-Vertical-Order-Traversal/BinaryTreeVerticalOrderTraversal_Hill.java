package com.sv.leetcode123.theLeecodeAwakens;
import com.sv.leetcode123.ch5_tree.TreeNode;
import java.util.*;

/**
 * Created by hill on 2016/11/28.
 *
 * Time: O(n)
 * Space : O(n)
 */
public class BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        Map<TreeNode, Integer> map = new HashMap<>(); //  column of the node
        Map<Integer, List<Integer>> colMap = new HashMap<>();  // how many node in each of column

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        map.put(root, 0);

        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {

            TreeNode curNode = queue.poll();

            int curCol = map.get(curNode);

            if (!colMap.containsKey(curCol)) {
                colMap.put(curCol, new ArrayList<Integer>());
            }


            colMap.get(curCol).add(curNode.val);

            if (curNode.left != null) {
                queue.offer(curNode.left);
                map.put(curNode.left, curCol - 1);
            }

            if (curNode.right != null) {
                queue.offer(curNode.right);
                map.put(curNode.right, curCol + 1);
            }

            minCol = Math.min(minCol, curCol);
            maxCol = Math.max(maxCol, curCol);
        }


        for (int i = minCol; i <= maxCol; i++) {
            if (colMap.containsKey(i)) {
                result.add(colMap.get(i));
            }

        }


        return result;
    }

}
