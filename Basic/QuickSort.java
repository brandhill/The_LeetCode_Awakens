import java.util.Arrays;

public class QuickSort {

  public void sort(int[] nums) {
    quicksort2(nums, 0, nums.length-1);
  }

  public void quicksort(int[] nums, int left, int right) {

    int k = partition(nums, left, right);
    System.out.println(left + " ~ " + right + " @ " + k);
    if(k - left > 1) quicksort(nums, left, k-1);
    if(right - k > 1) quicksort(nums, k+1, right);
  }

  private int partition(int[] nums, int left, int right) {
    int n = right - left + 1;
    int pIdx = left + (int) (Math.random() * n);
    swap(nums, right, pIdx);
    int pivot = nums[right];
    int storedIdx = left;
    for(int i=left; i<right; i++) {
      if(nums[i] <= pivot) {
        swap(nums, storedIdx, i);
        storedIdx++;
      }
    }
    swap(nums, storedIdx, right);

    // System.out.println("" + pivot);
    // for(int i=0; i<nums.length; i++) {
    //   System.out.print(nums[i] + ", ");
    // }
    // System.out.println("");

    return storedIdx;
  }

  public void quicksort2(int[] nums, int left, int right) {

      int n = right - left + 1;
      int pIdx = left + (int) (Math.random() * n);
      int pivot = nums[pIdx];

      // this solution having problem determain k
      int l = left;
      int r = right;
      while(l <= r) {
        while(nums[l] < pivot) l++;
        while(nums[r] > pivot) r--;
        if(l <= r) {
          swap(nums, l, r);
          l++;
          r--;
        }
      }

      if(left < r) quicksort2(nums, left, r);
      if(l < right) quicksort2(nums, l, right);

    }

  private void swap(int[] nums, int idx1, int idx2) {
    int tmp = nums[idx1];
    nums[idx1] = nums[idx2];
    nums[idx2] = tmp;
  }

  public static void main(String[] args) {
    QuickSort sort = new QuickSort();

    int n = 4;
    int[] sample = new int[n];
    int[] nums = new int[n];
    for(int i=0; i<n; i++) {
      int val = (int)(Math.random() * 100);
      sample[i] = val;
      nums[i] = val;
    }

    System.out.println("DATA");
    for(int i=0; i<nums.length; i++) {
      System.out.print(nums[i] + ", ");
    }
    System.out.println("");

    Arrays.sort(sample);
    sort.sort(nums);

    System.out.println("RESULT");
    for(int i=0; i<nums.length; i++) {
      System.out.print(nums[i] + ", ");
    }
    System.out.println("");

    for(int i=0; i<nums.length; i++) {
      if(sample[i] != nums[i]) {
        System.out.println("WORNG");
        break;
      }
    }
  }
}
