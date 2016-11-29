public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        int i = 0, countFor2 = 0;

        while (i < m + n) {
            if (i >= m + countFor2) break;
            if (i == 0 && nums2[countFor2] <= nums1[i]) {
                insert(nums1, 0, nums2[countFor2]);
                ++countFor2;
            } else if (i != 0 && countFor2 != n && nums1[i - 1] <= nums2[countFor2] && nums1[i] >= nums2[countFor2]) {
                insert(nums1, i, nums2[countFor2]);
                ++countFor2;
            }
            ++i;
        }

        for (int j = n - 1; j >= countFor2; --j) {
            nums1[nums1.length - (n - j)] = nums2[j];
        }
    }

    private void insert(int[] nums, int index, int value) {
        System.out.println("inserting " + value + " to index " + index);
        for (int i = nums.length - 1; i > index; --i) {
            nums[i] = nums[i - 1];
        }
        nums[index] = value;
    }
}
