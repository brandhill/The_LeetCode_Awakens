public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        boolean[] used = new boolean[nums.length];
        int[] permutation = new int[nums.length];
        backtrack(nums, 0, used, permutation, result);
        
        return result;
    }
    
    private void backtrack(int[] nums, int n, boolean[] used, int[] permutation, List<List<Integer>> result) {
        if(n == nums.length) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int v : permutation) {
                list.add(v);
            }
            result.add(list);
            return;
        }
        
        for(int i=0; i<nums.length;i++) {
            if(used[i])
                continue;
                
            used[i] = true;
            permutation[n] = nums[i];

            backtrack(nums, n+1, used, permutation, result);
            used[i] = false;
        } 
    }
}
