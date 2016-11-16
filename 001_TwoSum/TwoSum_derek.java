public class Solution {
  public int[] twoSum(int[] nums, int target) {
	final int len = null != nums ? nums.length : 0;
	if (len <= 0) {
	  return null;
	}

	HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
	for (int i =0; i<len; i++) {
	  if (result.containsKey(target - nums[i])) {
		int[] ans = new int[2];
		ans[0] = i;
		ans[1] = result.get(target - nums[i]);
		return ans;
	  }
	  result.put(nums[i], i);
	}
	return null;
  }
}
