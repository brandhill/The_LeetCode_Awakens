public class Solution {
    private int largestIndex;
    public int search(int[] nums, int target) {
        largestIndex = nums.length - 1;
        int[] array = reorderArray(nums);
        int result = binarySearch(array, 0, array.length, target);
        if (result < 0) {
            return -1;
        } else {
            return (largestIndex + result + 1)%array.length;
        }
    }

    private int[] reorderArray(int[] nums) {
        int[] result = new int[nums.length];
        largestIndex = nums.length - 1;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i + 1] < nums [i]) {
                largestIndex = i;
                break;
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            result[i] = nums[(i + largestIndex + 1)%nums.length];
        }

        return result;
    }

    private static int binarySearch(int[] nums, int begin, int end, int target) {
        int index = begin + (end - begin) / 2;
        if (begin > end) {
            return -1; 
        }

        try {
            if (target == nums[index]) {
                return index;
            } else if (target > nums[index]) {
                return binarySearch(nums, begin + (end - begin)/2 + 1, end, target);
            } else {
                return binarySearch(nums, begin, begin + (end - begin)/2 - 1, target);
            }
        } catch (Exception e) {
            return -1;
        }
    }   
}
