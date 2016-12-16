public class Solution {
    public int[] countBits(int num) {
        if(num == 0)
            return new int[1];
            
        int[] ret = new int[num+1];
        int last = 1;
        ret[0] = 0;
        for(int i=1;i<=num;i++) {
            ret[i] = ret[i % last] + 1;
            if(isPowerOfTwo(i)) last = i;
        }
        return ret;
    }
    
    boolean isPowerOfTwo (int x)
    {
      return ((x != 0) && (x & (x - 1))==0);
    }
}
