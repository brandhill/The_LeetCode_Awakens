public class Solution {
    /**
     * Time :O(n)
     * Space:O(1)
     */
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        nums[1] = nums[1] < nums[0] ? nums[0] : nums[1];
        for(int i=2; i < nums.length; i++) {
            nums[i] = Math.max((nums[i-2] + nums[i]), nums[(i-1)]);
        }
        return nums[nums.length-1];
    }
    
    /**
     * Time :O(n)
     * Space:O(n)
     */
    public int rob1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        for(int i=0; i < n; i++) {
            dp[i+2] = Math.max((dp[i] + nums[i]), dp[(i+2)-1]);
        }
        
        return dp[n+1];
    }
}
