import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hill on 2016/11/27.
 *
 * Time: O(n)
 * Space: O(n)
 */
public class MaximumSizeSubarraySumEqualsK {

    public static int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // get the prefixSum array
        int[] M = new int[nums.length + 1];
        M[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            M[i + 1] = M[i] + nums[i];
        }

        Map<Integer, Integer> myMap = new HashMap<>();
        int result = 0;
        for (int i = 0; i < M.length; i++) {
            // Find match value
            Integer index = myMap.get(M[i] - k);
            if (index != null) {
                result = Math.max(result, i - index);

                System.out.println(">> get result: " + result);
            }
            // update myMap only if M[i] is a new value
            Integer getValue = myMap.get(M[i]);
            if (getValue == null) {
                myMap.put(M[i], i);

            }
        }
        return result;
    }


    //////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////

    public static int maxSubArrayLen2(int[] nums, int k) {
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k) max = i + 1;
            else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }
}
