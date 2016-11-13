/**
 * Author: Derek Lai
 * Questions:
 * 1.
 * 
 * Time: O(n)
 * Space:O(1)
 */ 
public class Solution {
  public void sortColors(int[] nums) {
	final int length = null != nums ? nums.length : 0;
	if (length <= 0) {
	  return;
	}

	int redIdx = 0, blueIdx = length - 1;
	for (int i=0; i<= blueIdx; i++) {
	  while(2 == nums[i] && i < blueIdx) {
		swap(nums, i, blueIdx--);
	  }
	  while(0 == nums[i] && i > redIdx) {
		swap(nums, i, redIdx++);
	  }
	}
  }

  private void swap(int[] nums, int oriIdx, int targetIdx) {
	int temp = nums[oriIdx];
	nums[oriIdx] = nums[targetIdx];
	nums[targetIdx] = temp;
  }
}
