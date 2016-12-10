public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int k = n/2; k>= 1; k--) {
            if( n % k != 0) {
                continue;
            }
            
            boolean allEqual = true;
            for(int seg = 1; seg < n / k && allEqual; seg++) {
                for(int i=0;i<k;i++) {
                    //System.out.println(k + " " + seg + " " + i);
                    if( s.charAt(seg * k + i) != s.charAt(i)) {
                        allEqual = false;
                        break;
                    }
                }
            }
            if(allEqual)
                return true;
        }
        return false;
    }

    public boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        int i = 0;
        int j = 1;
        int d = 0;
        int count = 0;
        while(j < n) {
            if(s.charAt(j) == s.charAt(i)) {
                d= j-i;
                if(d > n/2)
                    return false;
                    
                if(count == 0) {
                    count = d;
                }
                i++;
                j++;
                count--;
            } else {
                i = 0;
                j=d +1;
                count = 0;
                while(j < n && s.charAt(j) != s.charAt(i)) {
                    j++;
                }
                if(j == n)
                    return false;

            }

        }

        return count == 0 && i == n-d;
        
    }
}
