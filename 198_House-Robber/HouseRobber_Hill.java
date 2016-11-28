public class Solution {
    /**
     * Time :O(n)
     * Space:O(1)
     *
     * 目前房子 n，可以拿到的錢
     * max = Max( 現在這棟 + 前前一可以拿到的最大金額 , 前一棟可以拿到的最大金額 )
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max((nums[i - 2] + nums[i]), nums[(i - 1)]);
        }
        return nums[nums.length - 1];
    }
}
