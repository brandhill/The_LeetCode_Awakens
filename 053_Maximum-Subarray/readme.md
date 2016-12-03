/*
 * DP method: ret = max {dp(1), dp(2), ... dp (n)}
 * dp(n) = dp(n - 1) < 0 ? nums[n] : dp(n-1) + nums[n];
 * Time: O(n)
 * Space:O(1)
 */
 
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
