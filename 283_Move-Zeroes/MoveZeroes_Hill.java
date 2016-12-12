/**
 * Time  :O(n)
 * Space :O(1)
 * <p>
 * https://leetcode.com/problems/move-zeroes/
 * <p>
 * The idea is to keep two pointer, p0 and p1
 * p0 find the first non-zero element
 * p1 find the first zero
 * then if p0 is before p1, no need to switch, move p0 forward
 * if p0 is after p1, then switch two elements
 */

public class Solution {
    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return;
        }

        int len = nums.length;
        int p0 = 0;
        int p1 = 0;

        while (p0 < len && p1 < len) {

            if (nums[p0] == 0) {
                p0++;
            } else if (nums[p1] != 0) {
                p1++;
            } else if (p0 > p1) {
                swap(nums, p0, p1);
                p0++;
                p1++;
            } else {
                p0++;
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}