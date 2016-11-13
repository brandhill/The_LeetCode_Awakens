/* 
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[mid] > nums[left] && nums[mid] < nums[right]) {
                // didn't rotated
                if (nums[mid] < target) {
                    // move right
                    left = mid + 1;
                } else {
                    // move left
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[left]) {
                    // left side is ordered
                    if (nums[mid] > target && nums[left] <= target) {
                        // move left
                        right = mid - 1;
                    } else {
                        // move right
                        left = mid + 1;
                    }
            } else if (nums[mid] < nums[right]) {
                    // right side is ordered
                    if (nums[mid] < target && nums[right] >= target) {
                        // move right
                        left = mid + 1;
                    } else {
                        // move left
                        right = mid - 1;
                    }
            } else {
                // move left
                left = mid + 1;
            }
        }
        
        return -1;
    }
}