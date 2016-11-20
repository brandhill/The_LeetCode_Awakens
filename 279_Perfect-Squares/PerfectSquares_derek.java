/**
 * 
 * Time : O(n*sqrt(n))
 * Space: O(n)
 * Question:
 * Static dp ?
 */ 
public class Solution {

  public int numSquares(int n) {
	if (n<=0) {
	  return 0;
	}
	int[] result = new int[n+1];
	//Why fill array with Integer.MAX_VALUE
	Arrays.fill(result, Integer.MAX_VALUE);
	result[0] = 0;
	for (int i = 1 ; i<=n ; i++) {
	  for (int j = 1; i - j*j >= 0 ; j++) {
		result[i] = Math.min(result[i], result[i-j*j]+1);
	  }
	}
	return result[n];
  }
}
