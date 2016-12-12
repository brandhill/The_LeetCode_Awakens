public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        
        int p1 = 0;
        int p2 = 1;
        
        while (p1 < p2) {
            while (nums[p2] == 0) {
                p2++;
                if (p2 >= nums.length) {
                    return;
                }
            }
            
            if (nums[p1] == 0) {
                int tmp = nums[p2];
                nums[p2] = nums[p1];
                nums[p1] = tmp;
            }
            
            p1++;
            
            if (p1 == nums.length - 1) {
                return;
            }
            
            if (p2 <= p1) {
                p2 = p1 + 1;
            }
        }
    }
}