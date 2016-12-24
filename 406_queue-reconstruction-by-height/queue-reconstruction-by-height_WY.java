public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] < b[0]) return 1;
                else if(a[0] == b[0]) return a[1] < b[1] ? -1 : 1;
                return -1;
            }
        });
        
        List<int[]> ret = new ArrayList<>(people.length);
        for(int i=0;i<people.length; i++) {
            int[] p = people[i];
            ret.add(p[1], p);
        }
        
        
        return ret.toArray(new int[people.length][]);
    }
}
