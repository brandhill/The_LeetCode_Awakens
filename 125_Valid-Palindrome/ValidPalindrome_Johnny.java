public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        
        s = s.toLowerCase();
        char[] charArray = s.toCharArray();
        
        int head = 0;
        int tail = charArray.length - 1;
        
        while (head < tail && head < charArray.length && tail >= 0) {
            while (!isValid(charArray[head])) {
                head++;
                
                if (head >= tail) {
                    return true;
                }
            }
            
            while (!isValid(charArray[tail])) {
                tail--;
                
                if (head >= tail) {
                    return true;
                }
            }
            
            if (charArray[head] != charArray[tail]) {
                return false;
            }
            
            head++;
            tail--;
        }
        
        return true;
    }
    
    private boolean isValid(char c) {
        if (c <= 'z' && c >= 'a') {
            return true;
        }
        
        if (c <= '9' && c >= '0') {
            return true;
        }
        
        return false;
    }
}