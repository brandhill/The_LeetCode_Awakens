public class Solution {
/*
 * DP method: ret = max {dp(1), dp(2), ... dp (n)}
 * dp(n) = dp(n - 1) < 0 ? nums[n] : dp(n-1) + nums[n];
 * Time: O(n)
 * Space:O(1)
 */
    public int maxSubArray(int[] nums) {
        int ret = nums[0];
        int maxEndWithPrev = 0;
        for (int v:nums) {
            maxEndWithPrev = (maxEndWithPrev < 0) ? v : maxEndWithPrev + v;
            if (maxEndWithPrev > ret) ret = maxEndWithPrev;
        }
        return ret;
    }
    
    /**
     * Divide and conquer
     * Divide: left and right
     * Merge: return the max(max of L, max of R, max of C)     
     *                 O
     *|<----------------------------------->|
     *         L                  R
     *|<---------------->|<---------------->|
     *           |<---------------->|     
     *                   C
     * C is the sum of 
     *   1. the largest sum starting from the right most element (denote it as rightMax) of L, 
     *   2. the largest sum starting from the left most element (denote it as leftMax) of R
     * How can we get leftMax and rightMax of O from L and R??
     *
     * leftMax = max (L.leftMax, L.total + R.LeftMax);
     *                   O
     * |<----------------------------------->|
     *          L                  R
     * |<---------------->|<---------------->|
     * |<---------------->|<--------->|  (L.total + R.LeftMax)
     * |<----------->| (L.leftMax)
     *
     * rightMax can be inferred by the same way
     *
     *  Time: O(n)
     * Space: O(log(n))
     */
    
    private static class ArrayData {
        public ArrayData(){}
        public ArrayData(int value) {
            max = leftMax = rightMax = total = value;
        }
        private int max;
        private int leftMax;
        private int rightMax;
        private int total;
    }
    
    private ArrayData maxSubArray(int[] nums, int start, int end) {
        if (start == end) return new ArrayData(nums[start]);
        int mid = (end+start)>>1;
        ArrayData dataL = maxSubArray(nums, start, mid);
        ArrayData dataR = maxSubArray(nums, mid+1, end);
        int max = Math.max(dataL.max, dataR.max);
        ArrayData ret = new ArrayData();
        ret.max= Math.max(max, dataL.rightMax + dataR.leftMax);
        ret.leftMax = Math.max(dataL.leftMax, dataL.total+dataR.leftMax);
        ret.rightMax = Math.max(dataR.rightMax, dataR.total+dataL.rightMax);
        ret.total = dataL.total + dataR.total;
        return ret;
    }
    public int maxSubArrayDAndC(int[] nums) {
        ArrayData ret = maxSubArray(nums, 0, nums.length-1);
        return ret.max;
    }
    
}
