// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should print vertical order such that each vertical line
    is separated by $ */
class GfG
{
    void verticalOrder(Node node) 
    {
        HashMap<Integer, List<Integer>> groups = new HashMap<>();
        
        preOrder(node, groups, 0);
        
        int n = groups.keySet().size();
        int[] gIdxArray = new int[n];
        int i = 0;
        for(int k : groups.keySet()) {
            gIdxArray[i++] = k;
        }
        Arrays.sort(gIdxArray);
        
        StringBuilder sb = new StringBuilder();
        for(int k : gIdxArray) {
            List<Integer> group = groups.get(k);
            for(int val : group) {
                sb.append(val).append(" ");
            }
            sb.append("$");
        }
        
        System.out.print(sb.toString());
    }
    
    void preOrder(Node node, Map<Integer, List<Integer>> groups, int groupIdx) {
        if(node == null) return;
        
        List<Integer> list = groups.get(groupIdx);
        if(list == null) {
            list = new ArrayList<>();
            groups.put(groupIdx, list);
        }
        list.add(node.data);

        if(node.left != null) preOrder(node.left, groups, groupIdx-1);
        if(node.right != null) preOrder(node.right, groups, groupIdx + 1);
    }
}
