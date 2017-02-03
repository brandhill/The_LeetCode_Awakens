public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum < S || (S + sum) %2 == 1)
            return 0;
        
        int targetSum = (S + sum) / 2;
        int[] dp = new int[targetSum+1];
        dp[0] = 1;
        
        for(int n : nums) {
            for(int j=targetSum; j>=n; j--) {
                dp[j] += dp[j-n];
            }
        }
        
        return dp[targetSum];
    }
}
