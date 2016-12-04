/*  Time: O(n)
 * Space: O(n)
 * 1. Two Sum + 303. Range Sum Query - Immutable  
 */
class Solution {
  public int maxSubArrayLen(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int max = 0;
    int sum = 0;
    for (int i = 0, size = nums.length; i < size; i++) {
      sum += nums[i];
      if (sum == k) {
        max = i+1;
      } else {
        Integer idx = map.get(sum-k);
        if (null != idx) max = Math.max(max, i - idx);
      }
      if (null == map.get(sum)) map.put(sum, i);
    }
    
    return max;
  }
}
