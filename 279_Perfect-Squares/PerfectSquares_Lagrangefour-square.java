public class Solution {

  public int numSquares(int n) {
        while (n % 4 == 0) n /= 4;
        if (n % 8 == 7) return 4;
        int a = 0;
        int square = 0;
        while (square <= n) {
          int b = (int)Math.sqrt(n - square);
          if (b*b + square == n) {
              int ret = 0;
              if (a > 0) ret +=1;
              if (b > 0) ret +=1;
              return  ret;
          }
          a++;
          square = a*a;
        }
        return 3;
  }
}
