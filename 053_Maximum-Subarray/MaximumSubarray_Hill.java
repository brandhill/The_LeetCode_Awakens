public class Solution {

    public int maxSubArray(int[] nums) {

        int len = nums.length;
        int[] DP = new int[len]; // DP[i] means the maximum subarray ending with A[i];
        DP[0] = nums[0];
        int max = DP[0];

        for(int i = 1 ; i < len ; i ++){

            DP[i] = (DP[i - 1] > 0 ? DP[i-1] : 0) + nums[i];
            max = Math.max(max, DP[i]);
        }
        return max;
    }

}
