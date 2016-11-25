/*  Time: O(n)
 * Space: O(1)
 */
public class Solution {
    public int rob(int[] nums) {
      int size = nums.length;
      int prevRobbed = 0;
      int prevSkipped = 0;
      for (int i : nums) {
          int current = i + prevSkipped;
          if (prevRobbed > prevSkipped) prevSkipped = prevRobbed;
          prevRobbed = current;
      }
      return (prevSkipped > prevRobbed) ? prevSkipped : prevRobbed;
    }
}
