public class Solution {
    public int compareVersion(String version1, String version2) {
        int n1=version1.length();
        int n2 = version2.length();
        int i=0;
        int j=0;
        int s1 = 0;
        int s2 = 0;
        while(i< n1 || j<n2) {
            while(i < n1 && version1.charAt(i) != '.') i++;
            while(j < n2 && version2.charAt(j) != '.') j++;
            
            int v1 = 0;
            if(i <= n1 && (i-s1 >= 0))
                v1 = Integer.parseInt(version1.substring(s1, i));
            int v2 = 0;
            if( j<= n2 && (j-s2 >= 0))
                v2 = Integer.parseInt(version2.substring(s2, j));
            if(v1 > v2) return 1;
            else if(v1 < v2) return -1;
            else {
                s1 = i+1;
                s2 = j+1;
                i++;
                j++;
            }
        }

        return 0;
    }
}
