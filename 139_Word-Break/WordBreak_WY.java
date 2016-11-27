/**
 * S = W1 + S1
 *   = W1 + W2 + S2
 *   = W3 + S3
 * 
 * D(n) 當子字串長度為N時，能否找到字的組合
 * D(n) = D(x) && isWord(x~n);
 * 
 * Time :O(n^2)
 * Space:O(n)
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        
        int shift = 1;
        boolean[] dp = new boolean[s.length() + shift];
        dp[0] = true;
        
        for(int i=1; i<dp.length; i++) {
            for(int j=0; j<i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i) )) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[dp.length -1];
    }
}
