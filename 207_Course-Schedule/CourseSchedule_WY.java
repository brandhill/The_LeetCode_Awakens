public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       if(numCourses <= 1) return true;
       
       List<List<Integer>> graph = new ArrayList<>(numCourses);
       
       for(int i=0; i<numCourses; i++) {
           graph.add(new ArrayList<Integer>());
       }
       
       for(int i=0; i<prerequisites.length; i++) {
           int course = prerequisites[i][0];
           int pre = prerequisites[i][1];
           graph.get(course).add(pre);
       }
       
       boolean[] visisted = new boolean[numCourses];
       for(int i=0; i<numCourses; i++) {
           if(dfs_isCyclic(graph, i, visisted)) return false;
       }
       
       return true;
    }
    
    private boolean dfs_isCyclic(List<List<Integer>> graph, int course, boolean[] visisted) {
        if(visisted[course])
            return true;
            
        visisted[course] = true;
        
        List<Integer> preCourses = graph.get(course);
        for(int i = 0; i<preCourses.size(); i++) {
            if(dfs_isCyclic(graph, preCourses.get(i), visisted))
                return true;
        }
        visisted[course] = false;
        
        return false;
    }
}
