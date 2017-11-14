class Solution {
    private Random mRandom = new Random();
    private int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int ret = -1, n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && mRandom.nextInt(++n) == 0) ret = i;
        }
        
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
