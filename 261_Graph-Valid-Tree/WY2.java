public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] group = new int[n];
        for(int i=0; i<n; i++) {
            group[i] = i;
        }
        
        for(int[] edge : edges) {
            int s = edge[0];
            int t = edge[1];
            if(find(group, s) == find(group, t))
                return false;
            
            union(group, s, t);
        }
        
        for(int i = 1; i<n; i++) {
            if(find(group, 0) != find(group, i))
                return false;
        }
        
        return true;
    }
    
    int find(int[] group, int pos) {
        if(group[pos] != pos) {
            group[pos] = find(group, group[pos]);
        }
        return group[pos];
    }

    void union(int[] group, int e1, int e2) {
        group[find(group, e2)] = find(group, e1);
    }
}
