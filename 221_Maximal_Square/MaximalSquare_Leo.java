public class Solution {
  private int getMax(int i, int j, char[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    int size = 1;
    int limit = Math.min(col - j, row - i);
    int x = i, y = j;
    outer:
    while (size < limit) {
      for (x = i + size, y = j; y < j+size;y++) {
        if (matrix[x][y] == '0') break outer;
      }
      for (x = i, y = j + size; x < i+size; x++) {
        if (matrix[x][y] == '0') break outer;
      }
      x = i + size;
      y = j + size;
      if (matrix[x][y] == '0') break outer;
      size++;
    }
    
    if (matrix[x][y] == '0') {
      for (int m = i; m <= x; m++) {
        for (int n = j; n < y; n++) {
          matrix[x][y] = '0';
        }
      }
    }
    
    return size;
  }
  
  public int maximalSquare(char[][] matrix) {
    int row = matrix.length;
    if (0 == row) return 0;
    int col = matrix[0].length;
    int max = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (matrix[i][j] == '0') continue;
        int size = getMax(i, j, matrix);
        if (max < size) max = size;
      }
    }
    return max*max;     
  }
}
