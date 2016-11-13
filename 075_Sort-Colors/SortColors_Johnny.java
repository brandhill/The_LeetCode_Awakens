/*
 * Time complexity: O(2n)
 * Space complexity: O(1)
 */
public class Solution {
    public void sortColors(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    zeroCount++;
                    break;
                case 1:
                    oneCount++;
                    break;
                case 2:
                    twoCount++;
                    break;
            }
        }
        
        int curIdx = 0;
        for (int i = 0; i < zeroCount; i++) {
            nums[curIdx] = 0;
            curIdx++;
        }
        for (int i = 0; i < oneCount; i++) {
            nums[curIdx] = 1;
            curIdx++;
        }
        for (int i = 0; i < twoCount; i++) {
            nums[curIdx] = 2;
            curIdx++;
        }
    }
}