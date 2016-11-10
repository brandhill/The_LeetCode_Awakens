public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, size = nums.length; i < size; i++) {
            Integer value = map.get(target - nums[i]);
            if (null != value) return new int[] {value, i};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }
}
