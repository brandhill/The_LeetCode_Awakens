public class MergeSort {

  public void mergeSort(int[] nums) {
    int[] tmpArray = new int[nums.length];
    //mergeSortRecursive(nums, results, 0, nums.length-1);
    mergeSortInterative(nums, tmpArray);
  }

  // merge two sorted array
  private void merge(int[] nums, int[] tmpArray, int l, int r) {
    int m = (r + l) / 2;
    int start1 = l;
    int end1 = m;
    int start2 = m + 1;
    int end2 = r;
    int k = l;
    while(start1 <= end1 && start2 <= end2) {
      tmpArray[k++] = nums[start1] < nums[start2] ? nums[start1++] : nums[start2++];
    }
    while(start1 <= end1) {
      tmpArray[k++] = nums[start1++];
    }
    while(start2 <= end2) {
      tmpArray[k++] = nums[start2++];
    }

    for(k=l; k<=r; k++) {
      nums[k] = tmpArray[k];
    }
  }

  private void mergeSortRecursive(int[] nums, int[] tmpArray, int l, int r) {
    int n = r - l + 1;
    if(n > 1) {
      int m = (r + l) / 2;
      mergeSortRecursive(nums, tmpArray, l, m);
      mergeSortRecursive(nums, tmpArray, m+1, r);
      merge(nums, tmpArray, l, r);
    }
  }

  private void mergeSortInterative(int[] nums, int[] tmpArray) {
    int n = nums.length;
    for(int currSize=1; currSize<n; currSize = 2*currSize) {
      for(int i=0; i<n; i+=2*currSize) {
        int start1 = i;
        int end2 = Math.min(start1 + 2*currSize -1, n-1);
        merge(nums, tmpArray, start1, end2);
      }
    }
  }

  public static void main(String[] args) {
    MergeSort sort = new MergeSort();

    int[] nums = new int[] {5, 4,3,2,1, 6,7,8};
    sort.mergeSort(nums);
    for(int i=0; i<nums.length; i++) {
      System.out.println(nums[i]);
    }
  }
}
