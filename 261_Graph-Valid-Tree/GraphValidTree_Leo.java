/*
 *  Time: O(V+E)
 * Space: O(V)
 */  
public boolean validTree(int n, int[][] edges) {
    if (edges.length == 0) return n == 1;
    boolean[] visited = new boolean[n];
    LinkedList<Integer>[] adj = new LinkedList[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new LinkedList<>();
    }
    for (int[] edge: edges) {
      int x = edge[0];
      int y = edge[1];
      adj[x].add(y);
      adj[y].add(x);
    }
    
    LinkedList<Integer> queue = new LinkedList<>();
    queue.add(edges[0][0]);
    visited[edges[0][0]] = true;
    int count = n;
    while (!queue.isEmpty()) {
      count--;
      Integer node = queue.removeFirst();
      for (Integer i:adj[node]) {
        if(visited[i]) return false;
        queue.add(i);
        visited[i] = true;
        adj[i].remove(node);
      }
    }
    
    return count == 0;
  }
