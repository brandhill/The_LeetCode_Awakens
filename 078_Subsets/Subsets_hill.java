/**
 * Created by hill on 2016/10/30.
 * <p>
 * Given a set of distinct integers, S, return all possible subsets.
 * <p>
 * Note: Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example, If S = [1,2,3], a solution is: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * <p>
 * <p>
 * Ask interviewer about following questions:
 * 1. Should we sort the output?
 * <p>
 * <p>
 * https://leetcode.com/problems/subsets/
 
 A general approach to backtracking questions in Java (Subsets, Permutations, Combination Sum, Palindrome Partitioning)
 https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
 
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        int size = 1 << nums.length; // subsets 的個數 會是 2^n， n 是 nums 的個數
        for (int i = 0; i < size; i++) {
            list.clear();
            for (int j = 0; j < nums.length; j++) {
                if ((1 & (i >>> j)) == 1) {
                    list.add(nums[j]);
                }
            }
            result.add(new ArrayList(list));
        }
        return result;
    }
}
