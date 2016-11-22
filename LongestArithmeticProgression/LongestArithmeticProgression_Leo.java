import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void log(String s) {
        System.out.println(s);
    }
    
    public static int llapDp(int[] arr, int size) {
      if (size <= 2) return size;
      int[][] dp = new int[size][size];
      int lastIndex = size - 1;
      for (int i = 0; i < size; i++) {
          dp[i][lastIndex] = 2;
      }
      
      int max = 2;
      for (int j = lastIndex-1; j > 0; j--) {
          int i = j - 1;
          int k = j + 1;
          while (i >= 0 && k < size) {
              int sum = arr[k]+arr[i];
              int target = arr[j]<<1;
              if (sum > target) {
                  dp[i--][j] = 2;
              } else if (sum < target){
                  k++;
              } else {
                  dp[i][j] = dp[j][k]+1;
                  if (dp[i][j] > max) max = dp[i][j];
                  i--;
                  k++;
              }
          }
          while (i>=0) {
              dp[i--][j] = 2;
          }
      }
      return max;
  }
    
  public static int llap(int[] arr, int size) {
    int max = 1;
    for (int i = 0; i < size; i++) {
        for (int j = i+1; j < size; j++) {
            int count = 2;
            int prev = arr[j];
            int d = prev - arr[i];
            for (int k = j+1; k < size; k++) {
                if (arr[k]-prev == d) {
                    count++;
                    prev = arr[k];
                }
            }
            if (max < count) max = count;
        }
    }
    return max;
  }
    
    public static void main (String[] args)
    {
        // Note that size of arr[] is considered 100 according to
        // the constraints mentioned in problem statement.
        int[] arr = new int[100];
 
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = sc.nextInt();
 
            // Input the array
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
 
            // Compute and print result
            System.out.println(llap(arr, n));
 
            t--;
        }
    }
}
