public class Solution {
    public boolean exist(char[][] board, String word) {
        int height = board.length;
        if (height == 0) {
            return false;
        }
        if (word.isEmpty()) {
            return false;
        }
        
        int width = board[0].length;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == charArray[0]) {
                    boolean[][] result = new boolean[height][width];
                    if (find(i, j, height, width, board, result, 1, charArray)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean find(int i, int j, int height, int width, char[][] board, boolean[][] result, int curIdx, char[] word) {
        if (curIdx >= word.length) {
            return true;
        }
        
        result[i][j] = true;
            
            if (i-1 >= 0 && !result[i-1][j] && board[i-1][j] == word[curIdx]) {
                if (find(i-1, j, height, width, board, result, curIdx+1, word)) {
                    return true;
                }
            }
            if (j-1 >= 0 && !result[i][j-1] && board[i][j-1] == word[curIdx]) {
                if (find(i, j-1, height, width, board, result, curIdx+1, word)) {
                    return true;
                }
            }
            if (i+1 < height && !result[i+1][j] && board[i+1][j] == word[curIdx]) {
                if (find(i+1, j, height, width, board, result, curIdx+1, word)) {
                    return true;
                }
            }
            if (j+1 < width && !result[i][j+1] && board[i][j+1] == word[curIdx]) {
                if (find(i, j+1, height, width, board, result, curIdx+1, word)) {
                    return true;
                }
            }
            
            result[i][j] = false;
            return false;
    }
}
