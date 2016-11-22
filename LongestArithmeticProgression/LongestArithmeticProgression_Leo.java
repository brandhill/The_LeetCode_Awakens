import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void log(String s) {
        System.out.println(s);
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
