/*
 * Question1 : Can we modify the input
 * time: O(n*m * (3^L)) n,m is array size, L is word length
 *Space: O(1)
 */
public class Solution {
  private boolean search(char[][] board, char[] word, int index, int x, int y) {
    if (index >= word.length) return true;
    if (x >= board.length || x<0 || y>= board[0].length || y<0) return false;
    char c = word[index];
    if (c != board[x][y] ) return false;
    index++;
    board[x][y] = 0;
    boolean ret = search(board, word, index, x-1,y)
      || search(board, word, index, x,y-1)
      || search(board, word, index, x+1,y)
      || search(board, word, index, x,y+1);
    board[x][y] = c;
    return ret;
  }
  
  public boolean exist(char[][] board, String word) {
    int row = board.length;
    int col = board[0].length;
    char[] wordChars = word.toCharArray();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (search(board, wordChars, 0, i, j)) return true;
      }
    }
    return false;
  }
}
