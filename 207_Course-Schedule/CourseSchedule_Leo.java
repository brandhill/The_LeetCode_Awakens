/*
 * BFS
 * Time complexity: O(numCourses + edges)
 * Space complexity: O(numCourses + edges)
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int [] dependancy: prerequisites) {
            int to = dependancy[1];
            int from = dependancy[0];
            if (!graph[from].contains(to)) {
                indegree[to]++;
                graph[from].add(to);
            }
        }
        
        LinkedList<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            for (int i : graph[queue.removeFirst()]) {
                if (--indegree[i] == 0) queue.add(i);
            }
        }

        return count == numCourses;
    }
}
