/**
 * Time :O(m+n)
 * Space:O(1)
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int endIdx = m + n - 1;
        int endIdx1 = m - 1;
        int endIdx2 = n - 1; 
        while(endIdx1 >= 0 && endIdx2 >=0) {
            if(nums1[endIdx1] > nums2[endIdx2]) {
                nums1[endIdx--] = nums1[endIdx1--];
            } else {
                nums1[endIdx--] = nums2[endIdx2--];
            }
        }
        while(endIdx2 >=0) {
            nums1[endIdx--] = nums2[endIdx2--];
        }
    }
}
