public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i+1;
            int hi = nums.length - 1;
            int sum = 0 - nums[i];
            if (i == 0 || (i > 0 && nums[i-1] != nums[i])) {
                while(lo < hi) {
                    if (nums[lo]+nums[hi] == sum) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[lo]);
                        list.add(nums[hi]);
                        result.add(list);
                        lo++;
                        hi--;
                    } else if (nums[lo]+nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        
        return new ArrayList(result);
    }
}