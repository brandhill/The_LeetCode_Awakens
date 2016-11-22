public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[][] graph = new int[numCourses][numCourses];
        
        for (int [] dependancy: prerequisites) {
            int to = dependancy[1];
            int from = dependancy[0];
            if (graph[from][to] == 0) {
                indegree[to]++;
                graph[from][to] = 1;
            }
        }
        
        LinkedList<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int from = queue.removeFirst();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (graph[from][i] != 0) {
                    if (--indegree[i] == 0) queue.add(i);
                }
            }
        }

        return count == numCourses;
    }
}
