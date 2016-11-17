public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null) throw new IllegalArgumentException("input is null!");
        if (matrix.length == 0) return 0;
        int maximalLength = 0;

        for (int i = 0; i < matrix.length; ++i) {
            if (maximalLength >= matrix.length - i) break;

            for (int j = 0; j < matrix[i].length; ++j) {
                if (maximalLength >= matrix[i].length - j) break;

                int max = 0;
                for (int x = 1; x <= matrix.length - i; ++x) {
                    if (isSquare(matrix, i, j, x)) {
                        ++max;
                    } else {
                        break;
                    }
                }

                if (max > maximalLength) {
                    maximalLength = max;
                }
            }
        }

        return maximalLength * maximalLength;
    }

    private boolean isSquare(char[][] matrix, int x, int y, int length) {
        if ((matrix.length - x) - length < 0 || (matrix[x].length - y) - length < 0) return false;

        for (int i = x; i < x + length; ++i) {
            for (int j = y; j < y + length; ++j) {
                if (matrix[i][j] != '1') return false;
            }
        }

        return true;
    }
}
