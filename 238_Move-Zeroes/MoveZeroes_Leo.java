public class Solution {
  public void moveZeroes(int[] nums) {
    int nextPlace = 0;
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      if (nums[i] != 0) nums[nextPlace++] = nums[i];
    }
    for (int i = nextPlace; i < size; i++) {
      nums[i] = 0;
    }
  }
}
