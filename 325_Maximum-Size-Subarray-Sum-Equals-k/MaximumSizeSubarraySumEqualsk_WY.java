import java.io.*;
import java.util.*;

class MaximumSizeSubarraySumEqualsk_WY {
  public int maxSubArray(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);

    int maxLength = Integer.MIN_VALUE;
    int sum = 0;
    for(int i=0; i<nums.length; i++) {
      sum += nums[i];
      if(!map.containsKey(sum)) {
        map.put(sum, i);
      }

      if(map.containsKey(sum - k)) {
        int idx = map.get(sum - k);
        maxLength = Math.max(maxLength, i - idx);
      }
    }

    System.out.println("" + maxLength);
    return maxLength;
  }


  public static void main(String[] args) {
    int[] nums = new int[] {1, -1, 5, -2, 3}; // 3
    int k = 3;
    int expect = 4;
    //int[] nums = new int[] {1, 7, 10, 13, 14, 19}; // 4
    //int[] nums = new int[] {5, 10, 15, 20, 25, 30}; // 6

    MaximumSizeSubarraySumEqualsk_WY sol = new MaximumSizeSubarraySumEqualsk_WY();
    int ret = sol.maxSubArray(nums, k);

    System.out.println(ret != expect ? "WRONG" : "PASS");
  }
}
