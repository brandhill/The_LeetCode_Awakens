/**
 * Time : O(m*n*4*k), k is the length of word
 * Space: O(1)
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;

        for(int i =0; i<rows; i++) {
            for(int j=0; j < columns; j++) {
                if(exist(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, String word, int i, int j, int d) {
        int rows = board.length;
        int columns = board[0].length;

        if(i<0 || j < 0 || i >= rows || j >= columns)
            return false;

        if(board[i][j] != word.charAt(d)) {
            return false;
        }
        
        if(d == word.length()-1 && board[i][j] == word.charAt(d))
            return true;

        char tmp = board[i][j];
        board[i][j] = '0';
        boolean isExist = exist(board, word, i, j+1, d+1)
            || exist(board, word, i, j-1, d+1)
            || exist(board, word, i+1, j, d+1)
            || exist(board, word, i-1, j, d+1) ;
        board[i][j] = tmp;

        return isExist;
    }
}
