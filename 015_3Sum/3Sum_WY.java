public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0; i<nums.length-2; i++) {
            if(i>0 && nums[i-1] == nums[i])
                continue;
            int left = i+1;
            int right = nums.length -1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    while(left < nums.length && nums[left] == nums[left-1])
                        left++;
                    right--;
                    while(right > 0 && nums[right] == nums[right+1])
                        right--;
                } else if(sum > 0) {
                    right--;
                    while(right > 0 && nums[right] == nums[right+1])
                        right--;
                } else {
                    left++;
                    while(left < nums.length && nums[left] == nums[left-1])
                        left++;
                }
                
            }
        }
        return result;
    }
}
