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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<TreeNode, Integer> gMap = new HashMap<>();
        gMap.put(root, 0);
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root != null)
            queue.offer(root);
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int groupId = gMap.get(node);
            List<Integer> list = map.get(groupId);
            if(list == null) {
                list = new ArrayList<>();
                map.put(groupId, list);
            }
            list.add(node.val);
            min = Math.min(min, groupId);
            max = Math.max(max, groupId);
            
            if(node.left != null) {
                queue.offer(node.left);
                gMap.put(node.left, groupId-1);
            }
            
            if(node.right != null) {
                queue.offer(node.right);
                gMap.put(node.right, groupId+1);
            }
        }

        List<List<Integer>> results = new ArrayList<>();
        for(int i=min;i<=max;i++) {
            results.add(map.get(i));
        }
        
        return results;
    }

}
