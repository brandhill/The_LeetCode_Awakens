  public int maximalSquare(char[][] matrix) {
    int row = matrix.length;
    if (0 == row) return 0;
    int col = matrix[0].length;
    int[] dpLen = new int[col];
    int max = 0;
    for (int i = 0; i < row; i++) {
      char[] c = matrix[i];
      int LeftUpper = 0;
      int prev = 0;
      for (int j = 0; j < col; j++) {
        int len = dpLen[j];
        if (c[j] == '0') {
          len = 0;
        } else {
          if (len > LeftUpper) len = LeftUpper;
          if (len > prev) len = prev;
          if (max < ++len) max = len;
        }
        LeftUpper = dpLen[j];
        dpLen[j] = prev = len;
      }
    }
    
    return max * max;     
  }
