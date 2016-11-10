public class Solution {
    // we can keep track the index of the first element of every groups.
    // move element to corret group by exchanging the value of current element and group first element
    // for example:
    // 0 1 1 1 2 2 2 0
    // ^ ^     ^     *
    // compare group2
    // 0 1 1 1 0 2 2 2
    // ^ ^     * ^
    // compare group1
    // 0 0 1 1 1 2 2 2
    // ^ * ^     ^
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 1)
            return;

        // use an array to keep track the index of group first element
        int[] groupIdx = new int[3];
        groupIdx[0] = -1;
        groupIdx[1] = -1;
        groupIdx[2] = -1;
        
        // iterate through the given array.
        for(int i=0; i<nums.length; i++) {
            int curr = i;
            int currGroup = nums[i];
            
            // now, compare the index of current element and first element of every groups.
            
            // because there is only 3 groups, the value of group variable starts from 2;
            int group = 2;
            // check groups which is larger than current element and its first element is placed 
            while(group > currGroup  && groupIdx[group] < curr) {
                // only check group which has elements. ignore empty groups
                if(groupIdx[group] != -1) {
                    nums[curr] = group;
                    curr = groupIdx[group];
                    nums[curr] = currGroup;
                    groupIdx[group]++;
                }
                group--;
            }
            
            if(groupIdx[currGroup] == -1) {
                groupIdx[currGroup] = curr;
            }
        }
    }
}
