/**
 * Created by hill on 15/11/2016.
 *
 * https://leetcode.com/problems/sort-colors/
 *
 *
 * Time: O(n)
 * Space: O(1)
 */
public class SortColors {
    public void sortColors(int[] nums) {

        int left = 0, right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0)
                swap(nums, i++, left++);
            else if (nums[i] == 1)
                i++;
            else if (nums[i] == 2)
                swap(nums, i, right--);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}