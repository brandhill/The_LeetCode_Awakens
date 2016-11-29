/*
 *  Time: O(n * L * N), where L is the sum of the average lengths of wordDict, N is the size of wordDict
 *  Because the skipping of inner loop, the real complexity is O(max (K * L * N, n)) 
 *  where K is the number of segments of string
 * Space: O(n)
 */
public class Solution {
  public boolean wordBreak(String s, Set<String> wordDict) {
    int size = s.length();
    boolean[] f = new boolean[size+1];
    f[0] = true;
    
    for (int i = 0; i < size;i++) {
      if (!f[i]) continue;
      for (String word:wordDict) {
        if (s.startsWith(word, i)) {
          f[word.length()+i] = true;
        }
      }
    }
    
    return f[size];
  }
  
/*
 *  Solution from discussion
 *  Time: O(n * n), however, s.substring is O(n), so, it should be O(n^3)
 * Space: O(n)
 */
  
  public boolean wordBreak(String s, Set<String> wordDict) {
      int size = s.length();
      boolean[] dp = new boolean[size+1];
      dp[0] = true;
      for (int i = 1; i <= size; i++) {
            for(int j=0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
      }
      return dp[size];
  }
  
  /*
   *  Solution from discussion
   *  Time: O(n * min(n, maxLen)) where maxLen is the length of longest word in wordDict
   *         however, s.substring is O(n), so, it should be O(n * min(n, maxLen) * min(n, maxLen))
   *  Because the skipping of inner loop, the real complexity is O(K * min(n, maxLen) * min(n, maxLen)) K>=1 
   *  where K is the number of segments of string
   * Space: O(n)
   */  
  public boolean wordBreak(String s, Set<String> wordDict) {
      int size = s.length();
      int maxLen = 0;
      for (String word:wordDict) {
        int len = word.length();
        if (maxLen < len) maxLen = len;
      }
    
      boolean[] dp = new boolean[size+1];
      dp[0] = true;

      int maxIndex = 0;
      for (int i = 0; i <= size && i<= maxIndex; i++) {
            if (!dp[i]) continue;
            int jMax = i + maxLen ;
            if (jMax >= size) jMax = size;
            for(int j= i + 1; j <= jMax; j++){
                if(wordDict.contains(s.substring(i, j))){
                    dp[j] = true;
                    if (maxIndex < j) maxIndex = j;
                }
            }
      }
      return dp[size];
  }
}
