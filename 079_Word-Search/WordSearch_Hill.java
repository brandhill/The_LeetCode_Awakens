package com.sv.leetcode123.theLeecodeAwakens;

/**
 * Created by hill on 2016/11/29.
 *
 * Space: O(1)
 * Time : O(n * m * k * 4)
 *
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int k) {
        int m = board.length;
        int n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false; // can't find any char in board
        }

        if (board[i][j] == word.charAt(k)) {
            char temp = board[i][j];
            board[i][j] = '#'; // mark this element is used before, shouldn't be compared next time.
            if (k == word.length() - 1) {
                return true;
            } else if (dfs(board, word, i - 1, j, k + 1)
                    || dfs(board, word, i + 1, j, k + 1)
                    || dfs(board, word, i, j - 1, k + 1)
                    || dfs(board, word, i, j + 1, k + 1)) {
                return true;
            }
            board[i][j] = temp;
        }

        return false;
    }
}
