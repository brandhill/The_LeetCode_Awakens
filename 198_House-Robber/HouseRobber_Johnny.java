public class Solution {
    // n = 1: num[0]
    // n = 2: max(mResult[0], nums[1])
    // n = 3: max(mResult[n-2]+nums[n], mResult[n-1])
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        ArrayList<Integer> mResults = new ArrayList();
        mResults.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            int nonAdj = (i >= 2 ? mResults.get(i-2) : 0)+ nums[i];
            int adj = mResults.get(i-1);
            mResults.add(nonAdj > adj ? nonAdj : adj);
        }
        
        return mResults.get(nums.length - 1);
    }
}