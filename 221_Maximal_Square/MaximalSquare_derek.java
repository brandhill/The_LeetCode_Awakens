/**
 * Author:Derek Lai
 * Questions:
 * 1.
 * 
 * 
 */
public class Solution {
  public int maximalSquare(char[][] matrix) {
	if (null == matrix
		|| matrix.length == 0) {
	  return 0;   
	}
	int m = matrix.length, n = matrix[0].length, result = 0;
	int[][] b = new int[m+1][n+1];

	for (int i = 1 ; i<=m ; i++) {
	  for (int j = 1; j<=n ; j++) {
		if ('1' == matrix[i-1][j-1]) {
		  b[i][j] = Math.min(Math.min(b[i][j-1], b[i-1][j-1]), b[i-1][j]) + 1;
		  result = Math.max(b[i][j], result);
		}
	  }
	}
	return result * result;
  }
}
