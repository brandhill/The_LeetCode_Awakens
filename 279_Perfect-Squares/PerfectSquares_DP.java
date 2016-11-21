public class Solution {
  /*
   * Time:O(n * sqrt(n))
   * Space:O(n)
   * Bottum up
   */


  public int numSquares1(int n) {
    int[] d = new int[n+1];
    d[0] = 0;
    
    for (int i = 1; i <= n; i++) {
      int value = Integer.MAX_VALUE;
      for (int m = 1, square = 1; square <= i; m++, square = m*m) {
        int v = d[i - square];
        if (value > v) value = v;
      }  
      d[i] = value+1;
    }
    return d[n];
  }
  
  /*
   * Time:O(n * sqrt(n))
   * Space:O(n)
   * Bottum up
   */
  
   public int numSquares2(int n) {
      int dp[] = new int[n + 1];
      Arrays.fill(dp, Integer.MAX_VALUE);
      for (int i = 1, square = 1; square <= n; i++, square = i*i) {
          dp[square] = 1;
      }
      for (int i = 1; i <= n; i++) {
          int value = dp[i]+1;
          for (int j = 1, next = i + 1; next <= n; j++, next = i+j*j) {
              if (value < dp[next]) dp[next] = value;
          }
      }
      return dp[n];
   }
   
  /* 
   * Time: O(n * sqrt(n))
   * Space:O(n)
   * Top-down
   */
   private int findNumSquares(int n, int[] d) {
        if ( n<=1 ) return 1;
        int ret = n;
        for (int m = (int) Math.sqrt(n), square = m*m; square >= 1; square = m * m, m--) {
            int preceder = n - square;
            if (preceder < 0) continue;
            if (preceder == 0) return 1;
            int value = d[preceder];
            if (value == 0) {
                value = findNumSquares(preceder, d);
                d[preceder] = value;
            }
            value += 1;
            if (ret > value) {
                ret = value;
            }
        }
        return ret;
    }
    
    public int numSquares(int n) {
        int size = n+1;
        int[] d = new int[size];
        return findNumSquares(n, d);
    }
}
