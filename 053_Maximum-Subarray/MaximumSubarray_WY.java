public class Solution {
    public int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            int sum = 0;
            for(int j=i+1; j<nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        
        return max;
    }
    
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int[] dp = new int[n + 1];
        for(int i=1; i<n+1; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i-1], nums[i-1]);
            max = Math.max(max, dp[i]);
        }
        
        return max;
        
    }
}
