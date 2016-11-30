public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<String, ArrayList<Integer>> resultMap = new HashMap<>();
        ArrayList<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                for (int k = j + 1; k < nums.length; ++k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);

                        StringBuilder key = new StringBuilder();
                        for (Integer item : list) {
                            key.append(item.toString() + " ");
                        }

                        if (!resultMap.containsKey(key.toString())) {
                            resultMap.put(key.toString(), list);
                            result.add(list);
                        }
                    }
                }
            }
        }

        return result;
    }
}
