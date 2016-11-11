public class Solution {
    public void sortColors(int[] nums) {
        int currentTarget = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != currentTarget) {
                if (!findAndExchange(nums, i, currentTarget)) {
                    ++currentTarget;
                    continue;
                }
            }
            if (currentTarget > 2) break;
            ++i;
        }
    }
    
    private boolean findAndExchange(int[] nums, int index, int color) {
        for (int i = index; i < nums.length; ++i) {
            if (nums[i] == color) {
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
                return true;
            }
        }
        return false;
    }
}