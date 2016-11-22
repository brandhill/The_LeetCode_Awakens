/*
 *  Time: O (n * log(k))
 * Space: O(k)
 */
public class Solution {
  public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> queue = new PriorityQueue<>(k);
      for (int i = 0; i < k ; i++) {
        queue.add(nums[i]);
      }
    
      for (int i = k, size = nums.length; i < size; i++) {
        if (queue.peek() < nums[i]) {
          queue.poll();
          queue.add(nums[i]);
        }
      }
      return queue.peek();
  }
}
