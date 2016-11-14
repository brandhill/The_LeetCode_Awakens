public class Solution {
  public int search(int[] nums, int target) {
    int l = 0, h = nums.length-1;
    int first = nums[0];
    while (l <= h) {
        int m = (l + h) / 2;
        int mV = nums[m]; //3, 1, 3
        if (mV < first && target >= first) {
          h = m - 1;
          continue;
        } else if (mV >= first && target < first) {
          l = m + 1;
          continue;
        }
                   
        if (mV < target) {
            l = m + 1;
        } else if (mV > target) {
            h = m - 1;
        } else {
            return m;
        }
    }
    return -1;
  }
}
