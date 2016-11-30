public class Solution {
    public boolean exist(char[][] board, String word) {
        int x = board.length;
        int y = board[0].length;

        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                System.out.println("checking for board i=" + i + ", j=" + j);
                if (dfs(board, word, i, j, -1, -1, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int currentX, int currentY, int prevX, int prevY, int pivot) {
        if (currentX >= board.length ||
                currentY >= board[0].length ||
                currentX < 0 ||
                currentY < 0) {
            return false;
        }

        char target = board[currentX][currentY];
        int wordLen = word.length();

        if (target != word.charAt(pivot)) {
            System.out.println("target doe not match.");
            return false;
        }

        int next = pivot + 1;
        if (next == wordLen) {
            return true;
        } else {
            boolean result = false;

            int nextX = 0, nextY = 0;
            for (int shift = 0; shift < 4; ++shift) {
                switch(shift) {
                    case 0:
                        nextX = currentX;
                        nextY = currentY + 1;
                        break;
                    case 1:
                        nextX = currentX + 1;
                        nextY = currentY;
                        break;
                    case 2:
                        nextX = currentX;
                        nextY = currentY - 1;
                        break;
                    case 3:
                        nextX = currentX - 1;
                        nextY = currentY;
                        break;
                }

                if (!((nextX == prevX) && (nextY == prevY))) {
                    result |= dfs(board, word, nextX, nextY, currentX, currentY, next);
                }
            }

            return result;
        }
    }
}
