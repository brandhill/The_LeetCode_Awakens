public class Solution {

    public int search(int[] nums, int target) {

        for (int i = 0; i < nums.length; ++i) {

        }

    }

    int binarySearch(int[] nums, int target) {
        int begin = 0, end = nums.length = 1, i = nums.length / 2;

        while(true) {
            if (target == nums[i]) {
                return i;
            } else if (target > nums[i]) {
                begin = i;
                i = begin + (end - begin) / 2;
            } else {
                end = i;
                i = (end - begin) / 2;
            }
            if ( i == nums.length - 1 || i == 0) return -1;
        }
    }
}
