
1.DP method: 
 Ret = max {dp(1), dp(2), ... dp (n)}, where dp is the max subarray endded with element at position n
 dp(n) = dp(n - 1) < 0 ? nums[n] : dp(n-1) + nums[n];
 Time: O(n)
 Space:O(1)

 

2.Divide and conquer
- Divide: left and right

- Merge: return the max(max of L, max of R, max of C)
                  O
|<----------------------------------->|

         L                  R
|<---------------->|<---------------->|
           |<---------------->|     
                   C

 C is the max subarray of 
   1. the largest sum of subarray starting from the right most element (denote it as rightMax) of L, 
   2. the largest sum of subarray starting from the left most element (denote it as leftMax) of R

- How can we get leftMax and rightMax of O from L and R??

 leftMax = max (L.leftMax, L.total + R.LeftMax);
 
                   O
 |<----------------------------------->|
 
          L                  R
 |<---------------->|<---------------->|
 |<---------------->|<--------->|  (L.total + R.LeftMax)
 |<----------->| (L.leftMax)

 rightMax can be inferred by the same way

  Time: O(n), by Master Theorem T(n) = 2*T(n/2) + O (1)
 Space: O(log(n)
