public class Solution {
    /**
     * Time :O( nLogn)
     * Space:O(1)
     */
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n-k]; // n-1 -(k-1)
    }
    
    /**
     * use quicksort 的特性，每一次的loop會被一個元素放到正確的位置上
     * 只要檢查到元素被放在n-k的位置上時（小到大排序），就表示找到了
     * 
     * Avg: T(n) = T(n/2) + O(n)
     * Worst: T(n) = T(n-1) + O(n)
     */
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        
        int i = 0;
        int j = n-1;
        int x = -1;
        while(x != k) {
            x = n - partition(nums, i, j);
            if(x > k) {
                i = n-x + 1;
            } else {
                j = n-x -1;
            }
        }
        
        return nums[n-k];
    }
    
    private int partition(int[] nums, int i, int j) {
        int pivot = i;
        int val = nums[pivot];
        i++;
        while(i<=j) {
            if(nums[i] > val && nums[j] < val) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                i++;
                j--;
            }
            if(nums[i] <= val) i++;
            if(nums[j] >= val) j--;
        }
        
        int tmp = nums[j];
        nums[j] = nums[pivot];
        nums[pivot] = tmp;

        return j;
    }
}
