public class Solution {
  public void moveZeroes(int[] nums) {
	final int len = null != nums ? nums.length : 0;
	if (len <= 0) {
	  return;
	}
	int zIdx = -1, i = 0, temp = 0;
	for (i = 0; i<len; i++) {
	  if (0 == nums[i]) {
		if (zIdx == -1 ||
			(0 != nums[zIdx])) 
		  zIdx = i;
	  } else {
		if (zIdx >= 0 && 0 == nums[zIdx] && i > zIdx) {
		  temp = nums[i];
		  nums[i] = nums[zIdx];
		  nums[zIdx] = temp;
		  zIdx++;
		}
	  }
	}
  }
}
