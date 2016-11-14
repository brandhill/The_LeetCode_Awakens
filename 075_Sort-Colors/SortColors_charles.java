/*
 *		Author: Charles Tsai
 *		
 *		It's a 1-pass sorting algorithm and quite intuitive. Iterate all elements and check if it's the color we expect.
 *		If no, find the first right color and exchange with it. If cannot find right color, it means that current color is exhausted.
 *		Therefore we can start to try next color for the sorting.
 *
 *      Time complexity: O(n^2)
 *      Space complexity: O(1)
 */
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

/*
 *      If we follow the hint for this problem, we can have a 2-pass counting sort to accomplish this task.
 *
 *      Time complexity: O(n)
 *      Space complexity: O(m), m is the number of colors
 */

public void sortColors(int[] nums) {
    //count number of three colors
    int numOfRed = 0;
    int numOfBlue = 0;
    int numOfWhite = 0;
    if (nums.length == 0 || nums == null) return;

    //count red
    for (int i : nums) {
        if (i == 0) numOfRed++;
    }
    for (int i : nums) {//count white
        if (i == 1) numOfWhite++;
    }
    numOfBlue = nums.length - numOfRed - numOfWhite;
    for (int i = 0; i < numOfRed; i++) {
        nums[i] = 0;
    }
    for (int i = numOfRed; i < numOfRed + numOfWhite; i++) {
        nums[i] = 1;
    }
    for (int i = numOfRed + numOfWhite; i < nums.length; i++) {
        nums[i] = 2;
    }
}
