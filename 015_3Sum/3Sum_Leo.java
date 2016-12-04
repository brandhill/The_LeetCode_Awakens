public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ret = new LinkedList<>();
    if (nums.length < 3) return ret;
    Arrays.sort(nums);
    int prev = - nums[0] - 1;
    for (int i = 0, lastMid = nums.length - 2, last = lastMid+1; i <= lastMid; i++) {
      int mid = i+1;
      int end = last;
      int target = -nums[i];
      if (prev == target) continue;
      while (mid < end) {
        int value = nums[end] + nums[mid];
        if (value > target) {
          end--;
        } else if (value < target) {
          mid++;
        } else {
          ArrayList<Integer> list = new ArrayList<>(3);
          list.add(nums[i]);
          list.add(nums[mid]);
          list.add(nums[end]);
          ret.add(list);
          do {mid++;} while (mid < end && nums[mid] == nums[mid-1]);
          do {end--;} while (mid < end && nums[end] == nums[end+1]);
        }
      }
      prev = target;
    }
    
    return ret;
  }
}
