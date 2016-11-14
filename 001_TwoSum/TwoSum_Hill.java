/**
 * Created by hill on 15/11/2016.
 *
 *
 *
 * Question 1: Is input array sorted ?
 * Question 2: No duplicated entries ?
 *
 * Time: O(n)
 * Space: O(n)
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length; i++){
            if(map.get(nums[i]) != null){
                int[] result = {map.get(nums[i]), i};
                return result;
            }
            map.put(target - nums[i], i);
        }

        int[] result = {};
        return result;
    }

}