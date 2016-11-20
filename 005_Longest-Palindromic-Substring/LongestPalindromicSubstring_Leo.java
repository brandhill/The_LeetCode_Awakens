/**
  *   Time: O(n^2)
  *  Space: O(1)
  */

public class Solution {
    public String longestPalindrome(String s) {
        int totalLen = s.length();
        int centerLimit = (2*totalLen-2);
        int centerIndex = centerLimit/2;
        int currentCenter = centerIndex;
            
        int maxStartIndex = 0;
        int maxLen = 1;
        
        while (currentCenter < centerLimit) {
            if (currentCenter +1 < maxLen) break;
            int start;
            int end;
            if ((currentCenter & 1) == 1) {
                start = (currentCenter-1)/2;
                end = start+1;
            } else {
                start = currentCenter/2 -1;
                end = start+2;
            }
            int startLimit = (currentCenter > centerIndex) ? start - (totalLen - end - 1): 0;
            while (start >= startLimit) {
                if (s.charAt(start) != s.charAt(end)) break;
                start--;
                end++;
            }
            start++;
            if (start < currentCenter) {
                int len = end - start;
                if (len > maxLen) {
                    maxStartIndex = start;
                    maxLen = len;
                }
            }
            currentCenter = 2 * centerIndex - currentCenter;
            if (currentCenter <= centerIndex) currentCenter--;
        }
        
        return s.substring(maxStartIndex, maxStartIndex+maxLen);
    }
}
