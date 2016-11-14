/*
 *Use counting sort, its advantage is easy to extend if we have more colors.
 *Time : O(n)
 *Space: numbers of Color k, O(k). if k is constant, O(1)
 */

public class Solution {
  private static final int COLOR_NUMBER = 3;
  public void sortColors(int[] nums) {
    int[] colorSet = new int[COLOR_NUMBER];
    for (int v : nums) {
      colorSet[v]++;
    }
   
    int startIndex = 0;
    int number = 0;
    for (int i = 0; i < COLOR_NUMBER; i++) {
      number += colorSet[i];
      for (int j = startIndex; j < number; j++) {
        nums[j] = i;
      }
      startIndex = number;
    }
  }
}
