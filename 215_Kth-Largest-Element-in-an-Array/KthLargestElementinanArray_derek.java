/**
 * Time :O(NlogN)
 * Space:O(1)
 */
public class Solution {
  public int findKthLargest(int[] nums, int k) {
	final int len = null != nums ? nums.length : 0;
	if (len <= 0) {
	  return -1;
	}
	//Dual-Pivot Quicksort
	//Time: O(NlogN)
	Arrays.sort(nums);
	return nums[len-k];
  }
}
