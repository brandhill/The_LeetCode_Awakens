import java.io.*;
import java.util.*;

/*

Graph Valid Tree

Given n nodes labeled from 0 to n - 1 and a list of undirected edges
(each edge is a pair of nodes), check if these edges form a valid tree.


http://www.programcreek.com/2014/05/graph-valid-tree-java/

BFS
Time: O(n)
Space: O(n)

------------------

DFS
Time: O(n)
Space: O(n log n)

 */

class Solution {
    public boolean validTreeByBFS(int n, int[][] edges) {

        HashMap<Integer, ArrayList<Integer>> edgeMap = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            edgeMap.put(i, list);
        }

        for (int[] edge : edges) {
            edgeMap.get(edge[0]).add(edge[1]);
            edgeMap.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(0); // start from node 0

        while (!queue.isEmpty()) {
            int curNode = queue.poll();

            if (visited[curNode]) {
                return false;
            }

            visited[curNode] = true;

            for (int i : edgeMap.get(curNode)) {
                if (!visited[i]) {
                    queue.offer(i);
                }

            }
        }

        // make sure every node is visited, otherwise it is not a tree.
        for (boolean b : visited) {
            if (!b) return false;
        }

        return true;
    }

    //////////////////////////////////////////////////////////////////////////////

    public boolean validTreeByDFS(int n, int[][] edges) {

        HashMap<Integer, ArrayList<Integer>> edgeMap = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            edgeMap.put(i, list);
        }

        for (int[] edge : edges) {
            edgeMap.get(edge[0]).add(edge[1]);
            edgeMap.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        if(!dfsHelper(0, -1, edgeMap, visited)) {
            return false;
        }

        return true;
    }

    public boolean dfsHelper(int curr, int parent, HashMap<Integer, ArrayList<Integer>> edgeMap, boolean[] visited) {
        if (visited[curr]) {
            return false;
        }

        visited[curr] = true;

        for (int i : edgeMap.get(curr)) {
            if (i != parent && !dfsHelper(i, curr, edgeMap, visited)) {
                return false;
            }
        }

        return true;
    }


}
