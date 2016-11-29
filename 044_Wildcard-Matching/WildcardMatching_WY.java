public class Solution {
    public boolean isMatch(String s, String p) {
        int sIdx=0;
        int pIdx=0;
        int starIdxS = -1;
        int starIdxP = -1;
        while(sIdx < s.length()) {
            if(pIdx < p.length() && (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '?')) {
                sIdx++; pIdx++;
                continue;
            } else if(pIdx < p.length() && p.charAt(pIdx) == '*') {
                starIdxS = sIdx;
                starIdxP = pIdx;
                pIdx++;
                continue;
            } else if(starIdxP != -1) {
                pIdx = starIdxP + 1;
                starIdxS++;
                sIdx = starIdxS;
                continue;
            }
            
            return false;
        }
        
        while(pIdx < p.length() && p.charAt(pIdx) == '*') {
            pIdx++;
        }
        
        return pIdx == p.length();

    }
}
