public class Solution {

  public int numSquares(int n) {
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
}
