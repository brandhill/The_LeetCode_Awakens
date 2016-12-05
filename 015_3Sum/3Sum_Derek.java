public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
	final int len = null != nums ? nums.length : 0;
	if (len <= 0 ) {
	  return new LinkedList<>();
	}
	//Sort result first
	Arrays.sort(nums);
	List<List<Integer>> res = new LinkedList<>();
	int lo, hi, sum;
	for (int i = 0 ; i< len - 2; i++) {
	  if (0 == i || (i> 0 && nums[i] != nums[i-1])) {
		lo = i+1;
		hi = len - 1;
		sum = 0-nums[i];
		while (lo < hi) {
		  if (nums[lo] + nums[hi] == sum) {
			res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
			//Check is there same value from lo
			while(lo < hi && nums[lo] == nums[lo+1]) {
			  lo++;
			}
			//Check is there same value from hi
			while (lo < hi && nums[hi] == nums[hi-1]) {
			  hi--;
			}
			lo++;
			hi--;
		  } else if (nums[lo] + nums[hi] < sum) {
			lo++;
		  } else {
			hi--;
		  }
		}
	  }
	}
	return res;
  }
}
