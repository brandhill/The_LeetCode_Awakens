public class Solution {
    public int countBattleships(char[][] board) {
        int ncols = board[0].length;
        int nrows = board.length;
        int count = 0;
        for(int i=0; i<nrows; i++) {
            for(int j=0; j<ncols; j++) {
                if(board[i][j] == 'X') {
                    if((j>0 && board[i][j-1] == 'X') || (i > 0 && board[i-1][j] == 'X')) {
                        // skip
                    } else {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}
