public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        int sum = 0;
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            sum = sum + nums[i];
            if(sum == k) max = i+1;
            else if(map.containsKey(sum - k)) {
                max = Math.max( i - map.get(sum - k), max);
            } 
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return max;
    }
}
