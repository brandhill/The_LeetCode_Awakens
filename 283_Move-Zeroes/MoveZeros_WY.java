public class Solution {
    public void moveZeroes(int[] nums) {
        int p = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p] = tmp;
                p++;
            }
        }
    }
}
