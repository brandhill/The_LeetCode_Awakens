/**

[2, 7, 11, 15], target = 9
m + n = 9

Assume nums[i] is one of the answer,  we need to find nums[j] which value is target - nums[i];
obviously, we need to loop through the array from begining to find the answer.

it means, when we encounter nums[i], we need to store some data for later use
later, when we encounter nums[j], we can check the data we store to see if element j is what we looks for.

we can use a map to store the data.
map(nums[j] ) = i;

 */
public class Solution {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>(nums.length, 1);
    
    int[] ret = new int[2];
    
    for(int i=0; i<nums.length; i++) {
      int val = nums[i];
      if( map.containsKey(val) ) {
        ret[0] = map.get(val);
        ret[1] = i;
        break;
      }
      
      int delta = target - nums[i];
      map.put(delta, i);
    }
  
    return ret;
  }
}
