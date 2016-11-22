/*
 * BFS
 * Time complexity: O(numCourses + edges)
 * Space complexity: O(numCourses * numCourses)
 */

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graphs = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graphs[i] = new ArrayList<Integer>();
        }
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graphs[prerequisites[i][1]].add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()) {
            Integer course = queue.poll();
            count++;
            ArrayList<Integer> children = graphs[course];
            for (Integer c : children) {
                indegree[c]--;
                if (indegree[c] == 0) {
                    queue.add(c);
                }
            }
        }
        
        if (count == numCourses) {
            return true;
        }
        
        return false;
    }
}

/*
 * DFS
 * Time complexity: 
 * Space complexity: 
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graphs = new ArrayList[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graphs[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graphs[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(visited, i, graphs)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(boolean[] visited, int course, ArrayList<Integer>[] graphs) {
        if (visited[course]) {
            return false;
        }
        
        visited[course] = true;
        
        for (Integer children : graphs[course]) {
            if (!dfs(visited, children, graphs)) {
                return false;
            }
        }
        
        visited[course] = false;
        return true;
    }
}