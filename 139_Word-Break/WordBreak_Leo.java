/*
 *  Time: O(n * L), where L is the sum of the lengths of wordDict
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
}
