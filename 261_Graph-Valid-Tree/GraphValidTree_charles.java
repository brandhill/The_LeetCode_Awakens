public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> edgeList = new ArrayList<ArrayList<Integer>>();
        boolean[] traversedNodes = new boolean[n];

        for (int i = 0; i < n; ++i) {
            edgeList.add(new ArrayList<Integer>());
        }
        for (boolean node : traversedNodes) {
            node = false;
        }
        for (int[] edge : edges) {
            edgeList.get(edge[0]).add(edge[1]);
            edgeList.get(edge[1]).add(edge[0]);
        }

        if (!dfs(edgeList, traversedNodes, 0, -1)) return false;

        for (boolean node : traversedNodes) {
            if (!node) return false;
        }
        return true;
    }

    boolean dfs(ArrayList<ArrayList<Integer>> lists, boolean[] nodes, int current, int prev) {
        if (nodes[current]) return false;

        nodes[current] = true;

        for (Integer node : lists.get(current)) {
            if (node.intValue() != prev) {
                if (!dfs(lists, nodes, node.intValue(), current)) return false;
            }
        }
        return true;
    }
}
