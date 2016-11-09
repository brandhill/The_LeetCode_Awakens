public class Solution {

/*
 * Bit mask, time complexity O(1), 但本質和其他的方法一樣. 缺點是當數字不大時效能比較差(10^12以下是差的, 10^12~2^20不一定, 因為執行時間會被bit數影響,所以)
 * 在輸入為平均分布時這個最好, 但若以小整數為主就不見得好
 */

    private static final int MSB = 1<<15;
    public int mySqrt(int x) {
      int ret = 0;
      for (int mask = MSB; mask > 0; mask >>= 1) {
          int n = ret | mask;
          if (n <= x / n) ret = n;
      }
      return ret;
   }

/*
 * 牛頓法, 比較好, 可用在浮點數, 而且在這時候會厲害很多. 但time complexity不會證明. 數值方法的書沒人在討論整數的
 */
    public int mySqrt(int x) {
      int root = 1+(x>>1);
      int mag = 0;
      while (root > mag) {
        mag = x/root;
        root = (root+mag) >> 1;

      }
      return root;
   }
    
/*最慢
 */
    public int mySqrt(int x) {
        int h = x;
        int l = 1;
        while (h >= l) {
            int mid = (h+l)/2;
            int s = x/mid;
            if (s > mid) {
                l = mid+1;
            } else if (s < mid){
                h = mid-1;
            } else {
                return mid;
            }
        }
        return h; 
    }
    
/*
* 合併上面三招, 效能好都不行. 複雜度約lg(lg(x))
*/
public int mySqrt(int x) {
    int h = 31;
    int l = 0;
    int root = 0;
    int m = 0;
    int halfX = (x>>1);            
    while (h >= l) {
        m = (h+l)/2;
        root = 1<<m;
        if (root > x) {
            h = m -1;
        } else if (root < x) {
            if (root > halfX) break;
            l = m + 1;
        } else {
            break;
        }
    }
    root = 1<<((m>>1)+1);
    int mag = 0;
    while (root > mag) {
        mag = x/root;
        root = (root+mag) >> 1;
    }
    return root;
}
}
