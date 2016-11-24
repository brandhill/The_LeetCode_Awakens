/*
https://leetcode.com/problems/kth-largest-element-in-an-array/

http://pages.cs.wisc.edu/~vernon/cs367/notes/11.PRIORITY-Q.html
 */


public class Solution {
    /**
     * Time  :O( nLogn)
     * Space :O(1)
     */
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n - k];
    }


    /**
     * loop through the arrry, and put each of element in to a min-heap, whose size is k
     *
     *
     * Time  :O(n logn)
     * Space :O(1)
     */

    public int findKthLargest(int[] nums, int k) {
        if(nums.length < k){
            return 0;
        }
        Queue<Integer> pq = new PriorityQueue<Integer>(k);
        for(int i = 0; i < nums.length; i++){
            if(i < k){
                pq.add(nums[i]);
            }else{
                if(nums[i] > pq.peek()){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();

    }

}