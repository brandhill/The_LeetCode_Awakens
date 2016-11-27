import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public boolean isValidTree(int n, int[][] edges) {

    if(edges.length == 0)
        return n > 1 ? false : true;
    
    // create a adj list;
    List<List<Integer>> adjList = new ArrayList<>(n);
    for(int i=0; i<n; i++) {
      adjList.add(new ArrayList<Integer>());
    }
    
    for(int i=0; i<edges.length; i++) {
      int v1 = edges[i][0];
      int v2 = edges[i][1];
      adjList.get(v1).add(v2);
      adjList.get(v2).add(v1);
    }
    
    // create an array to trace if a node is visited;
    // check if it has cycle
    boolean[] visited = new boolean[n];
    // check if all nodes are connected
    boolean[] everVisited = new boolean[n];
    
    if(dfs(adjList, visited, everVisited, -1, edges[0][0])) {
      for(boolean flag : everVisited) {
        if(!flag) {
          System.out.println("disconnect");
          return false;
        }
      }
      return true;
    } else {
      System.out.println("cycle");
    }
    
    return false;
  }
  
  // return false if it detects cycle
  boolean dfs(List<List<Integer>> adjList, boolean[] visited, boolean[] everVisited, int pv, int v) {
    if(visited[v])
      return false;
    
    visited[v] = true;
    everVisited[v] = true;
    
    List<Integer> nodes = adjList.get(v);
    for(int node : nodes) {
      if(node == pv) continue;
      if(!dfs(adjList, visited, everVisited, v, node)) {
        System.out.println("cycle");
        return false;
      }
    }

    visited[v] = false;
    
    return true;
  }
  
  public static void main(String[] args) {
    Solution sol = new Solution();
    boolean ret = sol.isValidTree(5, new int[][] {{0, 1}, {1, 2}, {1, 3} });
    
    System.out.println("isValid=" + ret);
  }
}
