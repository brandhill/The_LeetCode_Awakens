public class MajorityElement {

    // Time : O(n)
    // Space : O(k), k means different number
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int len = nums.length;
        int max = 0, mElement = nums[0];
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > max) {
                    max = map.get(nums[i]);
                    mElement = nums[i];
                }
            }
        }
        return mElement;

    }


    // 既然 MajorityElement 一定會出現，而且次數會大於 n/2,
    // 就表示 把 先把 array 排序之後，取 nums[n/2] 就為 MajorityElement

    // Time : O(nlogn)
    // Space : O(1)

    public int majorityElement_2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);

        return nums[nums.length / 2];

    }
}
