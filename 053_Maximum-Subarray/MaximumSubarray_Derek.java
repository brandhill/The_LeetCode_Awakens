public class Solution {
  public int maxSubArray(int[] nums) {
	final int len = null != nums ? nums.length : 0;
	if (len <= 0) {
	  return 0;
	}
	int maxSoFar= nums[0], maxValue = nums[0];
	for (int i = 1; i<len; i++) {
	  maxValue = Math.max(maxValue+nums[i], nums[i]);
	  maxSoFar = Math.max(maxSoFar, maxValue);
	}
	return maxSoFar;
  }
}
