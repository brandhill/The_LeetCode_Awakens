/**
Time = O(n) + O(logN)
Space= O(1)
 */
public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null) return -1;
        if(nums.length == 1) return target == nums[0] ? 0 : -1;
        
        int pivotIdx = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i-1] > nums[i]) {
                pivotIdx = i;
                break;
            }
        }

        int count = nums.length;
        int retIdx = -1;
        int startIdx = 0, endIdx = nums.length-1;
        while(startIdx <= endIdx ) {
            int idx = (startIdx +  endIdx) / 2;
            int mappingIdx = (idx + pivotIdx) % count;
            if(nums[mappingIdx] == target) {
                retIdx = mappingIdx;
                break;
            } else if(nums[mappingIdx] > target) {
                endIdx = idx - 1;
            } else {
                startIdx = idx + 1;
            }
        }
        
        return retIdx;
    }
}
