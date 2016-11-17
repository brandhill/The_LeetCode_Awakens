import java.lang.StringBuilder;
import java.lang.System;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*

    We can use this website to verify our solution: https://www.random.org/integer-sets/

*/
public class LongestArithmeticProgression {

    private static final boolean DUMP_LAP = true;

    private static final LongestArithmeticProgression mInstance = new LongestArithmeticProgression();

    public static void main(String[] args) {

        int[] nums = new int[args.length];
        
        for (int i = 0; i < args.length; ++i) {
            nums[i] = Integer.parseInt(args[i]);
        }
        Arrays.sort(nums);
        
        System.out.println("The length of longest arithmetic progression is " + mInstance.findLLAP(nums));
    }

    // actual algorithm to get LLAP
    public int findLLAP(int[] nums) {

        int result = 0;
        for (int i = 0; i < nums.length; ++i) {
            int resultForIndex = findLLAPFrom(nums, i);
            result = resultForIndex > result ? resultForIndex : result;
        }

        return result;

    }

    private int findLLAPFrom(int[] nums, int begin) {
        HashMap<Integer, ArrayList<Integer>> mDiffMap = new HashMap<>();

        int target = nums[begin];

        for (int i = begin + 1; i < nums.length; ++i) {
            if (insertNode(mDiffMap, nums[i]) == -1) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums[begin]);
                list.add(nums[i]);
                mDiffMap.put(nums[i] - nums[begin], list);
            }
        }

        int result = 0;
        Set<Map.Entry<Integer, ArrayList<Integer>>> set = mDiffMap.entrySet();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : set) {
            ArrayList<Integer> list = entry.getValue();
            result = list.size() > result ? list.size() : result;
        }

        return result;
    }

    private int insertNode(HashMap<Integer, ArrayList<Integer>> map, int target) {
        Set<Map.Entry<Integer, ArrayList<Integer>>> set = map.entrySet();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : set) {
            int key = entry.getKey();
            ArrayList<Integer> list = entry.getValue();
            if (target - list.get(list.size() - 1) == key) {
                list.add(target);
                return key;
            }
        }

        return -1;
    }
}
