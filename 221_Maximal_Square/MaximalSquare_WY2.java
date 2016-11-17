/**
Time :O(N)
Space:O(N) N: matrix size
 */
public class Solution {
  /**
   Possible input:
   []
   ["1"]
   ["10","01"]
   ["010", "011", "011"]
   */
  public int maximalSquare(char[][] matrix) {
    int rLength = matrix.length;
    if(rLength==0) return 0;
    int cLength = matrix[0].length;

    int max = 0;
    int[][] calculated = new int[rLength+1][cLength+1];
    for(int i=0; i<rLength; i++) {
      for(int j=0; j<cLength; j++) {
        if(matrix[i][j] == '0') {
          calculated[i+1][j+1] = 0;
        } else {
          calculated[i+1][j+1] = 1 +
            Math.min(
              Math.min(calculated[i][j], calculated[i][j+1]),
              calculated[i+1][j]);
        }

        max = Math.max(max, calculated[i+1][j+1]);
      }
    }

    return max * max;
  }
}
