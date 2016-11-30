public class Solution {
    public boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;
        while(i<j) {
            // ignore non a-z chars
            while(i < s.length() && !isAlphanumeric(s.charAt(i))) {
                i++;
            }
            while(j > 0 && !isAlphanumeric(s.charAt(j))) {
                j--;
            }

            if(i<j && !isEqualIgnorecase(s.charAt(i),s.charAt(j))) {
                return false;
            }
                
            i++; j--;
        }
        
        return true;
    }
    
    private boolean isAlphanumeric(char s) {
        return (s >= '0' && s <='9') || (s >= 'a' && s <= 'z' ) || (s >= 'A' && s <= 'Z' );
    }
    
    private boolean isEqualIgnorecase(char c1, char c2) {
        int d = c1 - c2;
        if(c1 >= 'A' && c2 >= 'A') {
            d = d > 0 ? d : -d;
            if(d!= 0)
                d = d - ('a' - 'A');
        }
        return d == 0;
    }
}
