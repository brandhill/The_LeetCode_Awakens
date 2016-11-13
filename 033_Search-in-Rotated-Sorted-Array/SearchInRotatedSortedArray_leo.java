/*
 *  Time: O(log(n));
 * Space: O(1);
 */
public class Solution {
      private int getRotatedPin(int [] nums) {
        // index: 0, 1, 2, 3, 4, 5, 6, 7
        // value: 3, 4, 5, 6, 7, 0, 1, 2, => offset=5
        // the pin point satisfies that p[i-1] > p[i] where i-1 < i;
        int size = nums.length;
        int l = 0;
        int h = size-1;
        int m = 0;
        while (l < h) {
          m = (l+h)/2;
          int prevM = 0 == m ? size-1: m -1;
          if (nums[prevM]> nums[m]) return m;
        // index: 0, 1, 2, 3, 4, 5, 6, 7
        // value: 3, 4, 5, 6, 7, 0, 1, 2, => offset=5
        //        l        m           h  
          if (nums[h] < nums[m]) {
            l = m + 1;
          } else {
            h = m -1;
          }
        }
        // index: 0, 1, 2, 3, 4, 5, 6, 7
        // value: 1, 2, 3, 4, 5, 6, 7, 0, offset=0
        
        return l;
      }
      
      private int getRealIndex(int index, int offset, int size) {
        int ret = index+offset;
        if (ret >= size) {
          return ret - size;
        } else if (ret < 0){
          return ret + size;
        }
        return ret;
      }
      
      private int searhWithOffset(int nums[], int target, int offset) {
        int size = nums.length;
        int l =0;
        int h = size;
        while (l <= h) {
          int m = (l+h)/2;
          int indexM = getRealIndex(m, offset, size);
          int value = nums[indexM];
          if (value > target) {
            h = m - 1;
          } else if (value < target) {
            l = m + 1;
          } else {
            return indexM;
          }
        }
        return -1;
      }
      
      public int search(int[] nums, int target) {
        int offset = getRotatedPin(nums);
        return searhWithOffset(nums, target, offset);
      }
      
  public int searchByCheckingConsistency(int[] nums, int target) {
    int l = 0, h = nums.length-1;
    int first = nums[0];
    while (l <= h) {
        int m = (l + h) / 2;
        int mV = nums[m];
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
