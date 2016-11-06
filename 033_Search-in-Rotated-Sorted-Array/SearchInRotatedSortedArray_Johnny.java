/*
  Auther: Johnny Lee
  Time complexicity: O(logn)
  Space complexitty: O(1)
 */

public class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            int m = (l + r) / 2;
            if (target == nums[m]) {
                return m;
            }
            
            if (nums[l] <= nums[m]) {
                // left sorted
                if (target >= nums[l] && target < nums[m]) {
                    // target is on the left
                    r = m - 1;
                } else {
                    // target is on the right
                    l = m + 1;
                }
            } else {
                // right sorted
                if (target > nums[m] && target <= nums[r]) {
                    // target is on the right
                    l = m + 1;
                } else {
                    // target is on the left
                    r = m - 1;                    
                }
            }
        }
        
        return -1;
    }
}