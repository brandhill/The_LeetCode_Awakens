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
}
