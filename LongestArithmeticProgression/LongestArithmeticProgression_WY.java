import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public int llap(int[] nums) {
    int n = nums.length;
    
    HashMap<Integer, Integer> idxMap = new HashMap<>(n);
    for(int i=0; i<n; i++) {
      idxMap.put(nums[i], i);
    }

    int[][] dp = new int[n][n];
    for(int i=0; i<n-1; i++) {
      for(int j=i; j<n-1; j++) {
        dp[i][j] = nums[j+1] - nums[i];
      }
    }
    
    int max = 0;
    for(int i=0; i<n-1; i++) {
      for(int j=i; j<n-1; j++) {  
        int delta = dp[i][j];
    
        int len = 1;
        int k = i;
        int o = j;
        int nextNum = nums[k] + delta;
        while(idxMap.containsKey(nextNum)) {
          len++;
          
          k = idxMap.get(nextNum);
          nextNum = -1;
          for(int x = k; x<n-1; x++) {
            if(dp[k][x] == delta) {
              nextNum = nums[k] + dp[i][j];
              break;
            }
          }
        }
        max = Math.max(max, len);
        
      }
    }
    
    return max;
  }
  
  
  public static void main(String[] args) {
    //int[] nums = new int[] {1, 7, 10, 15, 27, 29}; // 3
    //int[] nums = new int[] {1, 7, 10, 13, 14, 19}; // 4
    //int[] nums = new int[] {5, 10, 15, 20, 25, 30}; // 6
    int[] nums = new int[] {69,146,288,365,389,530,777,1030,1052,1059,1076,1315,1407,1415,1682,1761,1809,1830,2034,2160,2224,2427,2469,2528,2707,2737,2974,2985,3251,3490,3580,3625,3762,3830,4397,4449,4483,4646,4698,5063,5139,5337,5464,5565,5633,5805,6006,6113,6201,6236,6402,6407,6512,6588,6616,6905,6970,7003,7087,7292,7324,7366,7384,7480,7592,7667,7724,7892,7979,8001,8010,8113,8200,8461,8498,8507,8546,8768,8780,9111,9169,9190,9234,9315,9316,9601,9900,9925,9982}; // 3

    Solution sol = new Solution();
    int max = sol.llap(nums);
    System.out.println(max);
  }
}
