/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    
    char[] mBuf = new char[4];
    int mPos = 0;
    int mCount = 0;
    boolean eof = false;
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if(eof)
            return 0;
            
        int count = 0;
        
        if(mCount != 0) {
            count = Math.min(n, mCount);
            for(int i = 0; i<count; i++) {
                buf[i] = mBuf[mPos + i];
            }
            mPos = (mPos + count) % 4;
            mCount -= count;
        }
        
        while(count < n) {
            int ret = read4(mBuf);
            if(ret == 0) {
                eof = true;
                break;
            }
            
            for(mPos=0;mPos<ret;mPos++) {
                buf[count] = mBuf[mPos];
                count++;
                if(count == n) {
                    mPos++;
                    mCount = ret - mPos;
                    break;
                }
            }
        }
        return count;
    }
}
